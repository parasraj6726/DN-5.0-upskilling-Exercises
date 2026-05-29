-- =============================================================
-- Q11: Daily New User Count
-- Find the number of users who registered each day
-- in the last 7 days.
-- =============================================================

SELECT
    registration_date,
    COUNT(user_id) AS new_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- To view all days (including days with 0 users), use a
-- calendar CTE approach:
WITH RECURSIVE calendar AS (
    SELECT CURDATE() - INTERVAL 6 DAY AS dt
    UNION ALL
    SELECT dt + INTERVAL 1 DAY FROM calendar WHERE dt < CURDATE()
)
SELECT
    c.dt               AS registration_date,
    COUNT(u.user_id)   AS new_users
FROM calendar c
LEFT JOIN Users u ON u.registration_date = c.dt
GROUP BY c.dt
ORDER BY c.dt;
