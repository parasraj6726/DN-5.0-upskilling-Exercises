-- =============================================================
-- Q7: Low Feedback Alerts
-- List all users who gave feedback with a rating less than 3,
-- along with their comments and associated event names.
-- =============================================================

SELECT
    u.user_id,
    u.full_name,
    u.email,
    e.title    AS event_title,
    f.rating,
    f.comments,
    f.feedback_date
FROM Feedback f
JOIN Users  u ON f.user_id  = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.rating, f.feedback_date;
