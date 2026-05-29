-- =============================================================
-- Q20: User Engagement Index
-- For each user, calculate how many events they attended
-- (registered for) and how many feedbacks they submitted.
-- =============================================================

SELECT
    u.user_id,
    u.full_name,
    u.city,
    COUNT(DISTINCT r.event_id)   AS events_registered,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted,
    ROUND(
        COUNT(DISTINCT f.feedback_id) /
        NULLIF(COUNT(DISTINCT r.event_id), 0) * 100, 1
    )                            AS feedback_rate_pct
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback       f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.city
ORDER BY events_registered DESC, feedbacks_submitted DESC;
