-- =============================================================
-- Q16: Unregistered Active Users
-- Find users who created an account in the last 30 days
-- but haven't registered for any events.
-- =============================================================

SELECT
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM Users u
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND u.user_id NOT IN (
      SELECT DISTINCT user_id FROM Registrations
  )
ORDER BY u.registration_date DESC;
