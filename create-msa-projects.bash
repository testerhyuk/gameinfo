if [ ! -d "microservices" ]; then
  mkdir microservices
fi

cd microservices

create_project() {
  local NAME=$1
  local PACKAGE=$2

  if [ -d "$NAME" ]; then
    echo "⚠️  '$NAME' 이미 존재하므로 건너뜁니다."
  else
    echo "🚀 '$NAME' 생성 중..."
    spring init \
      --boot-version=3.5.0 \
      --type=gradle-project \
      --java-version=24 \
      --packaging=jar \
      --name=$NAME \
      --package-name=$PACKAGE \
      --groupId=$PACKAGE \
      --dependencies=actuator,webflux \
      --version=1.0.0-SNAPSHOT \
      $NAME
  fi
}

create_project "product-service" "me.hyuk.gameinfo.core.product"
create_project "review-service" "me.hyuk.gameinfo.core.review"
create_project "recommendation-service" "me.hyuk.gameinfo.core.recommendation"
create_project "product-composite-service" "me.hyuk.gameinfo.composite.product"

cd ..