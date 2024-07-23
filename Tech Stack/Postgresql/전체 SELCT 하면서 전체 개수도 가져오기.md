https://stackoverflow.com/questions/28888375/run-a-query-with-a-limit-offset-and-also-get-the-total-number-of-rows

```sql
WITH CTE AS (
            SELECT
                p.means_no,
                <foreach item="item" collection="selectInput" separator=" + ">
                    SUM(CASE WHEN t.sclsf_nm = #{item} THEN 1 ELSE 0 END)
                </foreach> as counts
            FROM
                yidt_anls_fclt_mng t,
                yidt_link_saeolmeans p
            WHERE
                 ST_DWithin(t.geom, p.geom, #{distance})
                AND ( <foreach item="item" collection="selectInput" separator=" OR ">
                    t.sclsf_nm = #{item}
                    </foreach> )
            GROUP BY
                p.means_no
            HAVING
            <foreach item="item" collection="selectInput" separator=" AND ">
                SUM(CASE WHEN t.sclsf_nm = #{item} THEN 1 ELSE 0 END) > 0
            </foreach>
        )
        SELECT
            count(c.*) OVER() AS total
            ,l.means_no
            ,l.pnu
            ,l.address as addr
            ,l.land_jimk_code_nm
            ,ST_X(ST_Centroid(l.geom)) AS corx
            ,ST_Y(ST_Centroid(l.geom)) AS cory
            ,c.counts
        FROM
            yidt_link_saeolmeans l
        JOIN
            CTE c ON l.means_no = c.means_no
        ORDER BY c.counts DESC
        LIMIT 5
```