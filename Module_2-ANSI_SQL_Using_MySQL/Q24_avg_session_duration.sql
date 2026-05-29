-- =============================================================
-- Q24: Average Session Duration per Event
-- Compute the average duration (in minutes) of sessions
-- in each event.
-- =============================================================

SELECT
    e.event_id,
    e.title                                                        AS event_title,
    COUNT(s.session_id)                                            AS total_sessions,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS avg_duration_minutes,
    MIN(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time))           AS min_duration_minutes,
    MAX(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time))           AS max_duration_minutes
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY avg_duration_minutes DESC;
