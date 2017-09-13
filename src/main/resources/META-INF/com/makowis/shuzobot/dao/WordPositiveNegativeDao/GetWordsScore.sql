SELECT
  SUM(score)
FROM
  WordPositiveNegative
WHERE
  word IN /* words */('嬉しい')