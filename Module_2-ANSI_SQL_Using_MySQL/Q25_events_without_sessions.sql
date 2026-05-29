-- =============================================================
-- Q25: Events Without Sessions
-- List all events that currently have no sessions scheduled.
-- =============================================================

SELECT
    e.event_id,
    e.title    AS event_title,
    e.city,
    e.status,
    e.start_date,
    e.end_date
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.session_id IS NULL
ORDER BY e.start_date;
