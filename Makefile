
run:
	./gradlew clean run

test:
	docker-compose -f docker-compose.test.yml up --build --abort-on-container-exit --exit-code-form keep-sim-api --force-recreate
