-- =============================================================
-- Q1: User Upcoming Events
-- Show a list of all upcoming events a user is registered for
-- in their city, sorted by date.
-- =============================================================

SELECT
    u.user_id,
    u.full_name,
    u.city,
    e.event_id,
    e.title        AS event_title,
    e.start_date,
    e.end_date,
    e.status
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e        ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND e.city   = u.city
ORDER BY u.user_id, e.start_date;
