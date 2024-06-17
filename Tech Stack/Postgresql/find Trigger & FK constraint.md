## 테이블에 적용된 fk 제약조건 찾기
```sql title:'find foreign key constraint'
SELECT
	a.attname AS column_name,
	confrelid::regclass AS foreign_table_name,
	af.attname AS foreign_column_name,
	confdeltype AS on_delete
FROM
	pg_constraint AS c
JOIN
	pg_attribute AS a
	ON a.attnum = ANY (c.conkey)
	AND a.attrelid = c.conrelid
JOIN
	pg_attribute AS af
	ON af.attnum = ANY (c.confkey)
	AND af.attrelid = c.confrelid
WHERE
	c.contype = 'f'
	AND c.conrelid = '테이블명'::regclass;
	--AND c.conrelid = 'scdtw_pbadms_map_shrn_dept_mng'::regclass;
```

## 테이블에 적용된 트리거 찾기
```sql title:'find trigger on table'
SELECT
	t.tgname AS trigger_name,
	t.tgenabled AS enabled,
	c.relname AS table_name,
	pg_catalog.pg_get_triggerdef(t.oid, true) AS definition
FROM
	pg_catalog.pg_trigger t
JOIN
	pg_catalog.pg_class c ON t.tgrelid = c.oid
JOIN
	pg_catalog.pg_namespace n ON c.relnamespace = n.oid
WHERE
	c.relname = '테이블명'
	--c.relname = 'scdtw_pbadms_map_lyr_mng'
	AND NOT t.tgisinternal;
```