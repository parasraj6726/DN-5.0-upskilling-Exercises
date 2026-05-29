-- =============================================================
-- Q6: Event Resource Summary
-- Generate a report showing the number of resources
-- (PDFs, images, links) uploaded for each event.
-- =============================================================

SELECT
    e.event_id,
    e.title                                                  AS event_title,
    COUNT(r.resource_id)                                     AS total_resources,
    SUM(r.resource_type = 'pdf')                             AS pdf_count,
    SUM(r.resource_type = 'image')                           AS image_count,
    SUM(r.resource_type = 'link')                            AS link_count
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY e.event_id;
