-- =============================================================
-- Q12: Event with Maximum Sessions
-- List the event(s) with the highest number of sessions.
-- =============================================================

SELECT
    e.event_id,
    e.title             AS event_title,
    COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(session_id) AS cnt
        FROM Sessions
        GROUP BY event_id
    ) AS sub
)
ORDER BY e.event_id;
