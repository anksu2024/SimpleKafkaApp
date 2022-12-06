# pyspark --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.3.1

import pyspark.sql.functions as func
from pyspark.sql.types import StringType

# TODO: Replace `localhost` with the IP Address of your Local Machine
df = spark \
    .read \
    .format("kafka") \
    .option("kafka.bootstrap.servers", "localhost:9092") \
    .option("subscribe", "topic1") \
    .load()

df.printSchema()

final_df = df.select(
    func.col("key").cast(StringType()).alias("key"),
    func.col("value").cast(StringType()).alias("value")).show()

# Count number of records
final_df.count()

# Shows all the distinct keys in our data
final_df.select(func.col("key").cast(StringType())).alias("key").distinct().show()

