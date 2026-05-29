-- =============================================================
-- Q15: Event Session Time Conflict
-- Identify overlapping sessions within the same event
-- (session start and end times that conflict).
-- =============================================================

SELECT
    s1.event_id,
    e.title             AS event_title,
    s1.session_id       AS session_a_id,
    s1.title            AS session_a_title,
    s1.start_time       AS session_a_start,
    s1.end_time         AS session_a_end,
    s2.session_id       AS session_b_id,
    s2.title            AS session_b_title,
    s2.start_time       AS session_b_start,
    s2.end_time         AS session_b_end
FROM Sessions s1
JOIN Sessions s2 ON  s1.event_id   = s2.event_id
                 AND s1.session_id < s2.session_id   -- avoid duplicate pairs
JOIN Events   e  ON  s1.event_id   = e.event_id
WHERE s1.start_time < s2.end_time
  AND s1.end_time   > s2.start_time
ORDER BY s1.event_id, s1.session_id;
