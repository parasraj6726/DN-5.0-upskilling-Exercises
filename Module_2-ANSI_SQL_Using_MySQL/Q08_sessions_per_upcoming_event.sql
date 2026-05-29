-- =============================================================
-- Q8: Sessions per Upcoming Event
-- Display all upcoming events with the count of sessions
-- scheduled for them.
-- =============================================================

SELECT
    e.event_id,
    e.title          AS event_title,
    e.city,
    e.start_date,
    COUNT(s.session_id) AS total_sessions
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title, e.city, e.start_date
ORDER BY e.start_date;
