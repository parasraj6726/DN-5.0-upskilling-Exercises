-- =============================================================
-- Q23: Registration Trends
-- Show a month-wise registration count trend over the
-- past 12 months.
-- =============================================================

SELECT
    DATE_FORMAT(r.registration_date, '%Y-%m')   AS year_month,
    COUNT(r.registration_id)                    AS total_registrations
FROM Registrations r
WHERE r.registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(r.registration_date, '%Y-%m')
ORDER BY year_month;

-- Extended: also show new user registrations per month
SELECT
    DATE_FORMAT(u.registration_date, '%Y-%m')   AS year_month,
    COUNT(u.user_id)                            AS new_users
FROM Users u
WHERE u.registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY DATE_FORMAT(u.registration_date, '%Y-%m')
ORDER BY year_month;
