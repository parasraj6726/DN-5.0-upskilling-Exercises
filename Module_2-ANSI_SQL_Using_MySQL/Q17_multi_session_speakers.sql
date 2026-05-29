-- =============================================================
-- Q17: Multi-Session Speakers
-- Identify speakers who are handling more than one session
-- across all events.
-- =============================================================

SELECT
    speaker_name,
    COUNT(session_id)           AS total_sessions,
    COUNT(DISTINCT event_id)    AS events_covered,
    GROUP_CONCAT(title ORDER BY start_time SEPARATOR ' | ') AS session_titles
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(session_id) > 1
ORDER BY total_sessions DESC;
