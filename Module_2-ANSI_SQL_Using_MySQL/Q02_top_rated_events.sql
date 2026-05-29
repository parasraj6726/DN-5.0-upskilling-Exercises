-- =============================================================
-- Q2: Top Rated Events
-- Identify events with the highest average rating,
-- considering only those with at least 10 feedback submissions.
-- =============================================================

SELECT
    e.event_id,
    e.title,
    e.city,
    COUNT(f.feedback_id)       AS total_feedback,
    ROUND(AVG(f.rating), 2)    AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title, e.city
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;

-- Note: With the sample data provided (only 2 feedback per event),
-- no rows will be returned. To test, lower the threshold:
-- HAVING COUNT(f.feedback_id) >= 1
