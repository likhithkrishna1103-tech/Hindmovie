package f9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.q8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends l4 {
    public static final String[] B = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] C = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    public static final String[] D = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] E = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    public static final String[] F = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] G = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] H = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] I = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] J = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public static final String[] K = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    public static final String[] L = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    public final s0 A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m f4278z;

    public n(q4 q4Var) {
        super(q4Var);
        this.A = new s0(((r1) this.f307w).F);
        ((r1) this.f307w).getClass();
        this.f4278z = new m(this, ((r1) this.f307w).f4363v);
    }

    public static final String P1(List list) {
        return list.isEmpty() ? "" : l0.e.k(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    public static final void V1(ContentValues contentValues, Object obj) {
        o8.u.d("value");
        o8.u.g(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: all -> 0x006d, SQLiteException -> 0x00a4, TryCatch #0 {SQLiteException -> 0x00a4, blocks: (B:15:0x0072, B:17:0x0093, B:20:0x00a6), top: B:30:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6 A[Catch: all -> 0x006d, SQLiteException -> 0x00a4, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a4, blocks: (B:15:0x0072, B:17:0x0093, B:20:0x00a6), top: B:30:0x0072 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A1(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f307w
            f9.r1 r0 = (f9.r1) r0
            java.lang.String r1 = "select first_open_count from app2 where app_id=?"
            o8.u.d(r14)
            java.lang.String r2 = "first_open_count"
            o8.u.d(r2)
            r13.m1()
            r13.n1()
            android.database.sqlite.SQLiteDatabase r3 = r13.b2()
            r3.beginTransaction()
            r4 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r7 = 48
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r6.append(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String[] r6 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r7 = -1
            long r9 = r13.X1(r1, r6, r7)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            java.lang.String r6 = "app2"
            java.lang.String r11 = "app_id"
            if (r1 != 0) goto L72
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r1.<init>()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r9 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String r10 = "previous_install_count"
            r1.put(r10, r9)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r9 = 0
            r10 = 5
            long r9 = r3.insertWithOnConflict(r6, r9, r1, r10)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 != 0) goto L71
            f9.w0 r1 = r0.A     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            f9.r1.g(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            f9.u0 r1 = r1.B     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String r6 = "Failed to insert column (got -1). appId"
            f9.v0 r9 = f9.w0.u1(r14)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            r1.c(r9, r2, r6)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            goto Lbd
        L6d:
            r14 = move-exception
            goto Lc1
        L6f:
            r1 = move-exception
            goto Lac
        L71:
            r9 = r4
        L72:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r1.<init>()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r1.put(r11, r14)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r11 = 1
            long r11 = r11 + r9
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r1.put(r2, r11)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            java.lang.String r11 = "app_id = ?"
            java.lang.String[] r12 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            int r1 = r3.update(r6, r1, r11, r12)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            long r11 = (long) r1     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            int r1 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r1 != 0) goto La6
            f9.w0 r1 = r0.A     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            f9.r1.g(r1)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            f9.u0 r1 = r1.B     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            java.lang.String r4 = "Failed to update column (got 0). appId"
            f9.v0 r5 = f9.w0.u1(r14)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r1.c(r5, r2, r4)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            goto Lbd
        La4:
            r1 = move-exception
            goto Lab
        La6:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> La4
            r7 = r9
            goto Lbd
        Lab:
            r4 = r9
        Lac:
            f9.w0 r0 = r0.A     // Catch: java.lang.Throwable -> L6d
            f9.r1.g(r0)     // Catch: java.lang.Throwable -> L6d
            f9.u0 r0 = r0.B     // Catch: java.lang.Throwable -> L6d
            java.lang.String r6 = "Error inserting column. appId"
            f9.v0 r14 = f9.w0.u1(r14)     // Catch: java.lang.Throwable -> L6d
            r0.d(r6, r14, r2, r1)     // Catch: java.lang.Throwable -> L6d
            r7 = r4
        Lbd:
            r3.endTransaction()
            return r7
        Lc1:
            r3.endTransaction()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.A1(java.lang.String):long");
    }

    public final boolean B1(String str, String str2) {
        return W1("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final long C1(String str) {
        o8.u.d(str);
        return X1("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final void D1(String str, Long l10, long j4, com.google.android.gms.internal.measurement.b3 b3Var) {
        m1();
        n1();
        o8.u.g(b3Var);
        o8.u.d(str);
        r1 r1Var = (r1) this.f307w;
        byte[] bArrA = b3Var.a();
        w0 w0Var = r1Var.A;
        w0 w0Var2 = r1Var.A;
        r1.g(w0Var);
        w0Var.J.c(r1Var.E.a(str), Integer.valueOf(bArrA.length), "Saving complex main event, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j4));
        contentValues.put("main_event", bArrA);
        try {
            if (b2().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                r1.g(w0Var2);
                w0Var2.B.b(w0.u1(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e9) {
            r1.g(w0Var2);
            w0Var2.B.c(w0.u1(str), e9, "Error storing complex main event. appId");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E1(java.lang.String r26, java.lang.Long r27, java.lang.String r28, android.os.Bundle r29) {
        /*
            Method dump skipped, instruction units count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.E1(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.g2 F1(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f307w
            f9.r1 r0 = (f9.r1) r0
            o8.u.g(r5)
            r4.m1()
            r4.n1()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r1 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.b2()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            android.database.Cursor r5 = r3.rawQuery(r1, r5)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            if (r1 != 0) goto L36
            f9.w0 r1 = r0.A     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            f9.r1.g(r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            f9.u0 r1 = r1.J     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            java.lang.String r3 = "No data found"
            r1.a(r3)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
        L2e:
            r5.close()
            goto L5c
        L32:
            r0 = move-exception
            goto L45
        L34:
            r1 = move-exception
            goto L4d
        L36:
            r1 = 0
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            r3 = 1
            int r3 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            f9.g2 r2 = f9.g2.c(r3, r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            goto L2e
        L45:
            r2 = r5
            goto L62
        L47:
            r5 = move-exception
            r0 = r5
            goto L62
        L4a:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L4d:
            f9.w0 r0 = r0.A     // Catch: java.lang.Throwable -> L32
            f9.r1.g(r0)     // Catch: java.lang.Throwable -> L32
            f9.u0 r0 = r0.B     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "Error querying database."
            r0.b(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L5c
            goto L2e
        L5c:
            if (r2 != 0) goto L61
            f9.g2 r5 = f9.g2.f4188c
            return r5
        L61:
            return r2
        L62:
            if (r2 == 0) goto L67
            r2.close()
        L67:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.F1(java.lang.String):f9.g2");
    }

    public final void G1(String str, f4 f4Var) {
        m1();
        n1();
        o8.u.d(str);
        r1 r1Var = (r1) this.f307w;
        s8.a aVar = r1Var.F;
        w0 w0Var = r1Var.A;
        aVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        e0 e0Var = f0.f4161w0;
        long jLongValue = jCurrentTimeMillis - ((Long) e0Var.a(null)).longValue();
        long j4 = f4Var.f4181w;
        if (j4 < jLongValue || j4 > ((Long) e0Var.a(null)).longValue() + jCurrentTimeMillis) {
            r1.g(w0Var);
            w0Var.E.d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", w0.u1(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j4));
        }
        r1.g(w0Var);
        w0Var.J.a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", f4Var.f4180v);
        contentValues.put("source", Integer.valueOf(f4Var.f4182x));
        contentValues.put("timestamp_millis", Long.valueOf(j4));
        try {
            if (b2().insert("trigger_uris", null, contentValues) == -1) {
                r1.g(w0Var);
                w0Var.B.b(w0.u1(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e9) {
            r1.g(w0Var);
            w0Var.B.c(w0.u1(str), e9, "Error storing trigger URI. appId");
        }
    }

    public final void H1(String str, g2 g2Var) {
        o8.u.g(str);
        o8.u.g(g2Var);
        m1();
        n1();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", g2Var.g());
        contentValues.put("consent_source", Integer.valueOf(g2Var.f4190b));
        J1(contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String I1(java.lang.String r4, java.lang.String[] r5) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r0 = r3.b2()
            r1 = 0
            android.database.Cursor r1 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            boolean r5 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            if (r5 == 0) goto L18
            r5 = 0
            java.lang.String r4 = r1.getString(r5)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            r1.close()
            return r4
        L18:
            r1.close()
            java.lang.String r4 = ""
            return r4
        L1e:
            r4 = move-exception
            goto L32
        L20:
            r5 = move-exception
            java.lang.Object r0 = r3.f307w     // Catch: java.lang.Throwable -> L1e
            f9.r1 r0 = (f9.r1) r0     // Catch: java.lang.Throwable -> L1e
            f9.w0 r0 = r0.A     // Catch: java.lang.Throwable -> L1e
            f9.r1.g(r0)     // Catch: java.lang.Throwable -> L1e
            f9.u0 r0 = r0.B     // Catch: java.lang.Throwable -> L1e
            java.lang.String r2 = "Database error"
            r0.c(r4, r5, r2)     // Catch: java.lang.Throwable -> L1e
            throw r5     // Catch: java.lang.Throwable -> L1e
        L32:
            if (r1 == 0) goto L37
            r1.close()
        L37:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.I1(java.lang.String, java.lang.String[]):java.lang.String");
    }

    public final void J1(ContentValues contentValues) {
        r1 r1Var = (r1) this.f307w;
        try {
            SQLiteDatabase sQLiteDatabaseB2 = b2();
            if (contentValues.getAsString("app_id") == null) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.D.b(w0.u1("app_id"), "Value of the primary key is not set.");
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (sQLiteDatabaseB2.update("consent_settings", contentValues, r6.toString(), new String[]{r5}) == 0 && sQLiteDatabaseB2.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.B.c(w0.u1("consent_settings"), w0.u1("app_id"), "Failed to insert/update table (got -1). key");
            }
        } catch (SQLiteException e9) {
            w0 w0Var3 = r1Var.A;
            r1.g(w0Var3);
            w0Var3.B.d("Error storing into table. key", w0.u1("consent_settings"), w0.u1("app_id"), e9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.s K1(java.lang.String r31, java.lang.String r32, java.lang.String r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.K1(java.lang.String, java.lang.String, java.lang.String):f9.s");
    }

    public final void L1(String str, s sVar) {
        r1 r1Var = (r1) this.f307w;
        o8.u.g(sVar);
        m1();
        n1();
        ContentValues contentValues = new ContentValues();
        String str2 = sVar.f4380a;
        contentValues.put("app_id", str2);
        contentValues.put("name", sVar.f4381b);
        contentValues.put("lifetime_count", Long.valueOf(sVar.f4382c));
        contentValues.put("current_bundle_count", Long.valueOf(sVar.f4383d));
        contentValues.put("last_fire_timestamp", Long.valueOf(sVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(sVar.f4385g));
        contentValues.put("last_bundled_day", sVar.f4386h);
        contentValues.put("last_sampled_complex_event_id", sVar.i);
        contentValues.put("last_sampling_rate", sVar.f4387j);
        contentValues.put("current_session_count", Long.valueOf(sVar.f4384e));
        Boolean bool = sVar.f4388k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (b2().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.B.b(w0.u1(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.c(w0.u1(str2), e9, "Error storing event aggregates. appId");
        }
    }

    public final void M1(String str, String str2) {
        o8.u.d(str2);
        m1();
        n1();
        try {
            b2().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.c(w0.u1(str2), e9, "Error deleting snapshot. appId");
        }
    }

    public final r4 N1(String str, long j4, byte[] bArr, String str2, String str3, int i, int i10, long j7, long j10, long j11) {
        e3 e3Var;
        r1 r1Var = (r1) this.f307w;
        if (TextUtils.isEmpty(str2)) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.I.a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.g3 g3Var = (com.google.android.gms.internal.measurement.g3) a1.Z1(com.google.android.gms.internal.measurement.h3.w(), bArr);
            e3[] e3VarArrValues = e3.values();
            int length = e3VarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    e3Var = e3.B;
                    break;
                }
                e3Var = e3VarArrValues[i11];
                if (e3Var.f4106v == i) {
                    break;
                }
                i11++;
            }
            if (e3Var != e3.f4103x && e3Var != e3.A && i10 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.h3) g3Var.f2470w).p()).iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.j3) it.next()).i();
                    i3Var.b();
                    ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).T0(i10);
                    arrayList.add((com.google.android.gms.internal.measurement.j3) i3Var.e());
                }
                g3Var.b();
                ((com.google.android.gms.internal.measurement.h3) g3Var.f2470w).B();
                g3Var.b();
                ((com.google.android.gms.internal.measurement.h3) g3Var.f2470w).A(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length2 = strArrSplit.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        break;
                    }
                    String str4 = strArrSplit[i12];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        w0 w0Var2 = r1Var.A;
                        r1.g(w0Var2);
                        w0Var2.B.b(str4, "Invalid upload header: ");
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i12++;
                }
            }
            return new r4(j4, (com.google.android.gms.internal.measurement.h3) g3Var.e(), str2, map, e3Var, j7, j10, j11, i10);
        } catch (IOException e9) {
            w0 w0Var3 = r1Var.A;
            r1.g(w0Var3);
            w0Var3.B.c(str, e9, "Failed to queued MeasurementBatch from upload_queue. appId");
            return null;
        }
    }

    public final String O1() {
        ((r1) this.f307w).F.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Long l10 = (Long) f0.T.a(null);
        l10.getClass();
        String str = "(upload_type = 1 AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + l10 + ")";
        long jLongValue = ((Long) f0.S.a(null)).longValue();
        StringBuilder sb = new StringBuilder("(upload_type != 1 AND ABS(creation_timestamp - ");
        sb.append(jCurrentTimeMillis);
        sb.append(") > ");
        String strP = q4.a.p(sb, jLongValue, ")");
        StringBuilder sb2 = new StringBuilder(str.length() + 5 + strP.length() + 1);
        sb2.append("(");
        sb2.append(str);
        sb2.append(" OR ");
        sb2.append(strP);
        sb2.append(")");
        return sb2.toString();
    }

    public final void Q1(String str, g2 g2Var) {
        o8.u.g(str);
        m1();
        n1();
        H1(str, F1(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", g2Var.g());
        J1(contentValues);
    }

    public final g2 R1(String str) {
        o8.u.g(str);
        m1();
        n1();
        return g2.c(100, I1("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    public final s S1(String str, com.google.android.gms.internal.measurement.b3 b3Var, String str2) throws Throwable {
        s sVarK1 = K1("events", str, b3Var.s());
        if (sVarK1 != null) {
            long j4 = sVarK1.f4384e + 1;
            long j7 = sVarK1.f4383d + 1;
            return new s(sVarK1.f4380a, sVarK1.f4381b, sVarK1.f4382c + 1, j7, j4, sVarK1.f, sVarK1.f4385g, sVarK1.f4386h, sVarK1.i, sVarK1.f4387j, sVarK1.f4388k);
        }
        r1 r1Var = (r1) this.f307w;
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.E.c(w0.u1(str), r1Var.E.a(str2), "Event aggregate wasn't created during raw event logging. appId, event");
        return new s(str, b3Var.s(), 1L, 1L, 1L, b3Var.u(), 0L, null, null, null, null);
    }

    public final boolean T1() {
        return ((r1) this.f307w).f4363v.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f8 A[Catch: all -> 0x007a, SQLiteException -> 0x007c, TryCatch #7 {all -> 0x007a, blocks: (B:15:0x0066, B:18:0x006e, B:19:0x0072, B:45:0x00d0, B:47:0x00f8, B:48:0x010a, B:49:0x010e, B:50:0x011e, B:52:0x0124, B:53:0x0134, B:56:0x0147, B:68:0x016e, B:71:0x0176, B:77:0x0195, B:61:0x015d, B:75:0x0187, B:76:0x0190, B:98:0x0221, B:40:0x00c0, B:43:0x00c8), top: B:121:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010a A[Catch: all -> 0x007a, SQLiteException -> 0x007c, TRY_LEAVE, TryCatch #7 {all -> 0x007a, blocks: (B:15:0x0066, B:18:0x006e, B:19:0x0072, B:45:0x00d0, B:47:0x00f8, B:48:0x010a, B:49:0x010e, B:50:0x011e, B:52:0x0124, B:53:0x0134, B:56:0x0147, B:68:0x016e, B:71:0x0176, B:77:0x0195, B:61:0x015d, B:75:0x0187, B:76:0x0190, B:98:0x0221, B:40:0x00c0, B:43:0x00c8), top: B:121:0x0026 }] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U1(java.lang.String r21, long r22, long r24, b7.d r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.U1(java.lang.String, long, long, b7.d):void");
    }

    public final long W1(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = b2().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j4 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j4;
            } catch (SQLiteException e9) {
                w0 w0Var = ((r1) this.f307w).A;
                r1.g(w0Var);
                w0Var.B.c(str, e9, "Database error");
                throw e9;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long X1(String str, String[] strArr, long j4) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = b2().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j4 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j4;
            } catch (SQLiteException e9) {
                w0 w0Var = ((r1) this.f307w).A;
                r1.g(w0Var);
                w0Var.B.c(str, e9, "Database error");
                throw e9;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void Y1() {
        n1();
        b2().beginTransaction();
    }

    public final void Z1() {
        n1();
        b2().setTransactionSuccessful();
    }

    public final void a2() {
        n1();
        b2().endTransaction();
    }

    public final SQLiteDatabase b2() {
        m1();
        try {
            return this.f4278z.getWritableDatabase();
        } catch (SQLiteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error opening database");
            throw e9;
        }
    }

    public final void c2(String str) {
        s sVarK1;
        M1("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = b2().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (sVarK1 = K1("events", str, string)) != null) {
                            L1("events_snapshot", sVarK1);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e9) {
                w0 w0Var = ((r1) this.f307w).A;
                r1.g(w0Var);
                w0Var.B.c(w0.u1(str), e9, "Error creating snapshot. appId");
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d2(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.d2(java.lang.String):void");
    }

    public final void e2(String str, String str2) {
        o8.u.d(str);
        o8.u.d(str2);
        m1();
        n1();
        try {
            b2().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e9) {
            r1 r1Var = (r1) this.f307w;
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.d("Error deleting user property. appId", w0.u1(str), r1Var.E.c(str2), e9);
        }
    }

    public final boolean f2(t4 t4Var) {
        r1 r1Var = (r1) this.f307w;
        String str = t4Var.f4422b;
        m1();
        n1();
        String str2 = t4Var.f4421a;
        String str3 = t4Var.f4423c;
        if (g2(str2, str3) == null) {
            if (u4.l2(str3)) {
                if (W1("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str2}) >= Math.max(Math.min(r1Var.f4366y.u1(str2, f0.W), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str3)) {
                long jW1 = W1("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str2, str});
                r1Var.getClass();
                if (jW1 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("origin", str);
        contentValues.put("name", str3);
        contentValues.put("set_timestamp", Long.valueOf(t4Var.f4424d));
        V1(contentValues, t4Var.f4425e);
        try {
            if (b2().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.b(w0.u1(str2), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.c(w0.u1(str2), e9, "Error storing user property. appId");
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.t4 g2(java.lang.String r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f307w
            r1 = r0
            f9.r1 r1 = (f9.r1) r1
            o8.u.d(r12)
            o8.u.d(r13)
            r11.m1()
            r11.n1()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.b2()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r4 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L71
            if (r0 != 0) goto L37
            goto L95
        L37:
            r0 = 0
            long r8 = r3.getLong(r0)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L71
            r0 = 1
            java.lang.Object r10 = r11.z1(r3, r0)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L71
            if (r10 != 0) goto L44
            goto L95
        L44:
            r0 = 2
            java.lang.String r6 = r3.getString(r0)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L71
            f9.t4 r4 = new f9.t4     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L71
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            boolean r12 = r3.moveToNext()     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            if (r12 == 0) goto L6d
            f9.w0 r12 = r1.A     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            f9.r1.g(r12)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            f9.u0 r12 = r12.B     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r13 = "Got multiple records for user property, expected one. appId"
            f9.v0 r0 = f9.w0.u1(r5)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r12.b(r0, r13)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            goto L6d
        L67:
            r0 = move-exception
            r12 = r0
            goto L75
        L6a:
            r0 = move-exception
        L6b:
            r12 = r0
            goto L7f
        L6d:
            r3.close()
            return r4
        L71:
            r0 = move-exception
            r5 = r12
            r7 = r13
            goto L6b
        L75:
            r2 = r3
            goto L9b
        L77:
            r0 = move-exception
            r12 = r0
            goto L9b
        L7a:
            r0 = move-exception
            r5 = r12
            r7 = r13
            r12 = r0
            r3 = r2
        L7f:
            f9.w0 r13 = r1.A     // Catch: java.lang.Throwable -> L67
            f9.r1.g(r13)     // Catch: java.lang.Throwable -> L67
            f9.u0 r13 = r13.B     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = "Error querying user property. appId"
            f9.v0 r4 = f9.w0.u1(r5)     // Catch: java.lang.Throwable -> L67
            f9.q0 r1 = r1.E     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = r1.c(r7)     // Catch: java.lang.Throwable -> L67
            r13.d(r0, r4, r1, r12)     // Catch: java.lang.Throwable -> L67
        L95:
            if (r3 == 0) goto L9a
            r3.close()
        L9a:
            return r2
        L9b:
            if (r2 == 0) goto La0
            r2.close()
        La0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.g2(java.lang.String, java.lang.String):f9.t4");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List h2(String str) {
        String str2;
        r1 r1Var = (r1) this.f307w;
        o8.u.d(str);
        m1();
        n1();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                r1Var.getClass();
                cursorQuery = b2().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            if (string2 == null) {
                                string2 = "";
                            }
                            String str3 = string2;
                            long j4 = cursorQuery.getLong(2);
                            Object objZ1 = z1(cursorQuery, 3);
                            if (objZ1 == null) {
                                w0 w0Var = r1Var.A;
                                r1.g(w0Var);
                                w0Var.B.b(w0.u1(str), "Read invalid user property value, ignoring it. appId");
                                str2 = str;
                            } else {
                                str2 = str;
                                try {
                                    arrayList.add(new t4(str2, str3, string, j4, objZ1));
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    w0 w0Var2 = r1Var.A;
                                    r1.g(w0Var2);
                                    w0Var2.B.c(w0.u1(str2), e, "Error querying user properties. appId");
                                    arrayList = Collections.EMPTY_LIST;
                                }
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            str = str2;
                        }
                    }
                } catch (SQLiteException e10) {
                    e = e10;
                    str2 = str;
                }
            } finally {
            }
        } catch (SQLiteException e11) {
            e = e11;
            str2 = str;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b1, code lost:
    
        f9.r1.g(r13);
        r13.B.b(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List i2(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.i2(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean j2(e eVar) {
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        String str = eVar.f4083v;
        o8.u.g(str);
        if (g2(str, eVar.f4085x.f4404w) == null) {
            long jW1 = W1("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            r1Var.getClass();
            if (jW1 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", eVar.f4084w);
        contentValues.put("name", eVar.f4085x.f4404w);
        Object objA = eVar.f4085x.a();
        o8.u.g(objA);
        V1(contentValues, objA);
        contentValues.put("active", Boolean.valueOf(eVar.f4087z));
        contentValues.put("trigger_event_name", eVar.A);
        contentValues.put("trigger_timeout", Long.valueOf(eVar.C));
        v vVar = eVar.B;
        u4 u4Var = r1Var.D;
        w0 w0Var = r1Var.A;
        r1.e(u4Var);
        contentValues.put("timed_out_event", u4.R1(vVar));
        contentValues.put("creation_timestamp", Long.valueOf(eVar.f4086y));
        r1.e(u4Var);
        contentValues.put("triggered_event", u4.R1(eVar.D));
        contentValues.put("triggered_timestamp", Long.valueOf(eVar.f4085x.f4405x));
        contentValues.put("time_to_live", Long.valueOf(eVar.E));
        contentValues.put("expired_event", u4.R1(eVar.F));
        try {
            if (b2().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            r1.g(w0Var);
            w0Var.B.b(w0.u1(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e9) {
            r1.g(w0Var);
            w0Var.B.c(w0.u1(str), e9, "Error storing conditional user property");
            return true;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00f6: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:247), block:B:29:0x00f6 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.e k2(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.k2(java.lang.String, java.lang.String):f9.e");
    }

    public final void l2(String str, String str2) {
        o8.u.d(str);
        o8.u.d(str2);
        m1();
        n1();
        try {
            b2().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e9) {
            r1 r1Var = (r1) this.f307w;
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.d("Error deleting conditional property", w0.u1(str), r1Var.E.c(str2), e9);
        }
    }

    public final List m2(String str, String str2, String str3) {
        o8.u.d(str);
        m1();
        n1();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return n2(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        r3 = r2.A;
        f9.r1.g(r3);
        r3.B.b(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List n2(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.n2(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x03ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.b1 o2(java.lang.String r53) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1009
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.o2(java.lang.String):f9.b1");
    }

    public final void p2(b1 b1Var, boolean z10) {
        r1 r1Var = (r1) this.f307w;
        r1 r1Var2 = b1Var.f4024a;
        m1();
        n1();
        String strD = b1Var.D();
        o8.u.g(strD);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strD);
        f2 f2Var = f2.f4171x;
        q4 q4Var = this.f4215x;
        if (z10) {
            contentValues.put("app_instance_id", (String) null);
        } else if (q4Var.a(strD).i(f2Var)) {
            contentValues.put("app_instance_id", b1Var.E());
        }
        contentValues.put("gmp_app_id", b1Var.G());
        if (q4Var.a(strD).i(f2.f4170w)) {
            p1 p1Var = r1Var2.B;
            r1.g(p1Var);
            p1Var.m1();
            contentValues.put("resettable_device_id_hash", b1Var.f4028e);
        }
        p1 p1Var2 = r1Var2.B;
        r1.g(p1Var2);
        p1Var2.m1();
        contentValues.put("last_bundle_index", Long.valueOf(b1Var.f4029g));
        p1 p1Var3 = r1Var2.B;
        r1.g(p1Var3);
        p1Var3.m1();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b1Var.f4030h));
        p1 p1Var4 = r1Var2.B;
        r1.g(p1Var4);
        p1Var4.m1();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b1Var.i));
        contentValues.put("app_version", b1Var.N());
        p1 p1Var5 = r1Var2.B;
        r1.g(p1Var5);
        p1Var5.m1();
        contentValues.put("app_store", b1Var.f4033l);
        p1 p1Var6 = r1Var2.B;
        r1.g(p1Var6);
        p1Var6.m1();
        contentValues.put("gmp_version", Long.valueOf(b1Var.f4034m));
        p1 p1Var7 = r1Var2.B;
        r1.g(p1Var7);
        p1Var7.m1();
        contentValues.put("dev_cert_hash", Long.valueOf(b1Var.f4035n));
        p1 p1Var8 = r1Var2.B;
        r1.g(p1Var8);
        p1Var8.m1();
        contentValues.put("measurement_enabled", Boolean.valueOf(b1Var.f4036o));
        p1 p1Var9 = r1Var2.B;
        p1 p1Var10 = r1Var2.B;
        r1.g(p1Var9);
        p1Var9.m1();
        contentValues.put("day", Long.valueOf(b1Var.J));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_public_events_count", Long.valueOf(b1Var.K));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_events_count", Long.valueOf(b1Var.L));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_conversions_count", Long.valueOf(b1Var.M));
        p1 p1Var11 = r1Var2.B;
        r1.g(p1Var11);
        p1Var11.m1();
        contentValues.put("config_fetched_time", Long.valueOf(b1Var.R));
        p1 p1Var12 = r1Var2.B;
        r1.g(p1Var12);
        p1Var12.m1();
        contentValues.put("failed_config_fetch_time", Long.valueOf(b1Var.S));
        contentValues.put("app_version_int", Long.valueOf(b1Var.P()));
        contentValues.put("firebase_instance_id", b1Var.J());
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_error_events_count", Long.valueOf(b1Var.N));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_realtime_events_count", Long.valueOf(b1Var.O));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("health_monitor_sample", b1Var.P);
        contentValues.put("android_id", (Long) 0L);
        p1 p1Var13 = r1Var2.B;
        r1.g(p1Var13);
        p1Var13.m1();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(b1Var.f4037p));
        contentValues.put("dynamite_version", Long.valueOf(b1Var.b()));
        if (q4Var.a(strD).i(f2Var)) {
            p1 p1Var14 = r1Var2.B;
            r1.g(p1Var14);
            p1Var14.m1();
            contentValues.put("session_stitching_token", b1Var.f4041t);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(b1Var.y()));
        p1 p1Var15 = r1Var2.B;
        r1.g(p1Var15);
        p1Var15.m1();
        contentValues.put("target_os_version", Long.valueOf(b1Var.f4043v));
        p1 p1Var16 = r1Var2.B;
        r1.g(p1Var16);
        p1Var16.m1();
        contentValues.put("session_stitching_token_hash", Long.valueOf(b1Var.f4044w));
        q8.a();
        g gVar = r1Var.f4366y;
        w0 w0Var = r1Var.A;
        if (gVar.w1(strD, f0.Q0)) {
            p1 p1Var17 = r1Var2.B;
            r1.g(p1Var17);
            p1Var17.m1();
            contentValues.put("ad_services_version", Integer.valueOf(b1Var.f4045x));
            p1 p1Var18 = r1Var2.B;
            r1.g(p1Var18);
            p1Var18.m1();
            contentValues.put("attribution_eligibility_status", Long.valueOf(b1Var.B));
        }
        p1 p1Var19 = r1Var2.B;
        r1.g(p1Var19);
        p1Var19.m1();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(b1Var.f4046y));
        contentValues.put("npa_metadata_value", b1Var.w());
        p1 p1Var20 = r1Var2.B;
        r1.g(p1Var20);
        p1Var20.m1();
        contentValues.put("bundle_delivery_index", Long.valueOf(b1Var.F));
        contentValues.put("sgtm_preview_key", b1Var.C());
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("dma_consent_state", Integer.valueOf(b1Var.D));
        r1.g(p1Var10);
        p1Var10.m1();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(b1Var.E));
        contentValues.put("serialized_npa_metadata", b1Var.s());
        contentValues.put("client_upload_eligibility", Integer.valueOf(b1Var.t()));
        p1 p1Var21 = r1Var2.B;
        r1.g(p1Var21);
        p1Var21.m1();
        ArrayList arrayList = b1Var.f4040s;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                r1.g(w0Var);
                w0Var.E.b(strD, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        if (r1Var.f4366y.w1(null, f0.L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        p1 p1Var22 = r1Var2.B;
        r1.g(p1Var22);
        p1Var22.m1();
        contentValues.put("unmatched_pfo", b1Var.f4047z);
        p1 p1Var23 = r1Var2.B;
        r1.g(p1Var23);
        p1Var23.m1();
        contentValues.put("unmatched_uwa", b1Var.A);
        p1 p1Var24 = r1Var2.B;
        r1.g(p1Var24);
        p1Var24.m1();
        contentValues.put("ad_campaign_info", b1Var.H);
        try {
            SQLiteDatabase sQLiteDatabaseB2 = b2();
            if (sQLiteDatabaseB2.update("apps", contentValues, "app_id = ?", new String[]{strD}) == 0 && sQLiteDatabaseB2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                r1.g(w0Var);
                w0Var.B.b(w0.u1(strD), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e9) {
            r1.g(w0Var);
            w0Var.B.c(w0.u1(strD), e9, "Error storing app. appId");
        }
    }

    public final long q1(String str, com.google.android.gms.internal.measurement.h3 h3Var, String str2, Map map, e3 e3Var, Long l10) {
        int iDelete;
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        o8.u.g(h3Var);
        o8.u.d(str);
        m1();
        n1();
        if (T1()) {
            q4 q4Var = this.f4215x;
            long jC = q4Var.D.B.c();
            s8.a aVar = r1Var.F;
            w0 w0Var = r1Var.A;
            aVar.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jC) > ((Long) f0.N.a(null)).longValue()) {
                q4Var.D.B.e(jElapsedRealtime);
                m1();
                n1();
                if (T1() && (iDelete = b2().delete("upload_queue", O1(), new String[0])) > 0) {
                    r1.g(w0Var);
                    w0Var.J.b(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                o8.u.d(str);
                m1();
                n1();
                try {
                    int iU1 = r1Var.f4366y.u1(str, f0.A);
                    if (iU1 > 0) {
                        b2().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iU1)});
                    }
                } catch (SQLiteException e9) {
                    r1.g(w0Var);
                    w0Var.B.c(w0.u1(str), e9, "Error deleting over the limit queued batches. appId");
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrA = h3Var.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrA);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) "\r\n");
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(e3Var.f4106v));
        s8.a aVar2 = r1Var.F;
        w0 w0Var2 = r1Var.A;
        aVar2.getClass();
        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long jInsert = b2().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            r1.g(w0Var2);
            w0Var2.B.b(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e10) {
            r1.g(w0Var2);
            w0Var2.B.c(str, e10, "Error storing MeasurementBatch to upload_queue. appId");
            return -1L;
        }
    }

    public final j q2(long j4, String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        return r2(j4, str, 1L, false, false, z10, false, z11, z12, z13);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List r1(java.lang.String r19, f9.j4 r20, int r21) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.r1(java.lang.String, f9.j4, int):java.util.List");
    }

    public final j r2(long j4, String str, long j7, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        r1 r1Var = (r1) this.f307w;
        o8.u.d(str);
        m1();
        n1();
        String[] strArr = {str};
        j jVar = new j();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseB2 = b2();
                cursorQuery = sQLiteDatabaseB2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j4) {
                        jVar.f4228b = cursorQuery.getLong(1);
                        jVar.f4227a = cursorQuery.getLong(2);
                        jVar.f4229c = cursorQuery.getLong(3);
                        jVar.f4230d = cursorQuery.getLong(4);
                        jVar.f4231e = cursorQuery.getLong(5);
                        jVar.f = cursorQuery.getLong(6);
                        jVar.f4232g = cursorQuery.getLong(7);
                    }
                    if (z10) {
                        jVar.f4228b += j7;
                    }
                    if (z11) {
                        jVar.f4227a += j7;
                    }
                    if (z12) {
                        jVar.f4229c += j7;
                    }
                    if (z13) {
                        jVar.f4230d += j7;
                    }
                    if (z14) {
                        jVar.f4231e += j7;
                    }
                    if (z15) {
                        jVar.f += j7;
                    }
                    if (z16) {
                        jVar.f4232g += j7;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j4));
                    contentValues.put("daily_public_events_count", Long.valueOf(jVar.f4227a));
                    contentValues.put("daily_events_count", Long.valueOf(jVar.f4228b));
                    contentValues.put("daily_conversions_count", Long.valueOf(jVar.f4229c));
                    contentValues.put("daily_error_events_count", Long.valueOf(jVar.f4230d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(jVar.f4231e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(jVar.f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(jVar.f4232g));
                    sQLiteDatabaseB2.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.E.b(w0.u1(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e9) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.B.c(w0.u1(str), e9, "Error updating daily counts. appId");
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return jVar;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final boolean s1(String str) {
        e3[] e3VarArr = {e3.f4103x};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(e3VarArr[0].f4106v));
        String strP1 = P1(arrayList);
        String strO1 = O1();
        StringBuilder sb = new StringBuilder(strP1.length() + 61 + strO1.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strP1);
        sb.append(" AND NOT ");
        sb.append(strO1);
        return W1(sb.toString(), new String[]{str}) != 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x006c: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:109), block:B:19:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.emoji2.text.v s2(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f307w
            r1 = r0
            f9.r1 r1 = (f9.r1) r1
            o8.u.d(r12)
            r11.m1()
            r11.n1()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.b2()     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L71
            java.lang.String r4 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r5 = new java.lang.String[]{r0, r5, r6}     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L71
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L71
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6e android.database.sqlite.SQLiteException -> L71
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            if (r0 != 0) goto L33
            goto L83
        L33:
            r0 = 0
            byte[] r0 = r3.getBlob(r0)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            r5 = 2
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            boolean r6 = r3.moveToNext()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            if (r6 == 0) goto L5e
            f9.w0 r6 = r1.A     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            f9.r1.g(r6)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            f9.u0 r6 = r6.B     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            f9.v0 r8 = f9.w0.u1(r12)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            r6.b(r8, r7)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            goto L5e
        L59:
            r0 = move-exception
            r12 = r0
            goto L6c
        L5c:
            r0 = move-exception
            goto L73
        L5e:
            if (r0 != 0) goto L61
            goto L83
        L61:
            androidx.emoji2.text.v r6 = new androidx.emoji2.text.v     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            r7 = 10
            r6.<init>(r0, r4, r5, r7)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteException -> L5c
            r3.close()
            return r6
        L6c:
            r2 = r3
            goto L89
        L6e:
            r0 = move-exception
            r12 = r0
            goto L89
        L71:
            r0 = move-exception
            r3 = r2
        L73:
            f9.w0 r1 = r1.A     // Catch: java.lang.Throwable -> L59
            f9.r1.g(r1)     // Catch: java.lang.Throwable -> L59
            f9.u0 r1 = r1.B     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "Error querying remote config. appId"
            f9.v0 r12 = f9.w0.u1(r12)     // Catch: java.lang.Throwable -> L59
            r1.c(r12, r0, r4)     // Catch: java.lang.Throwable -> L59
        L83:
            if (r3 == 0) goto L88
            r3.close()
        L88:
            return r2
        L89:
            if (r2 == 0) goto L8e
            r2.close()
        L8e:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.s2(java.lang.String):androidx.emoji2.text.v");
    }

    public final void t1(Long l10) {
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        try {
            if (b2().delete("upload_queue", "rowid=?", new String[]{l10.toString()}) != 1) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.E.a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e9, "Failed to delete a MeasurementBatch in a upload_queue table");
            throw e9;
        }
    }

    public final void t2(com.google.android.gms.internal.measurement.j3 j3Var, boolean z10) {
        m1();
        n1();
        o8.u.d(j3Var.p());
        if (!j3Var.b2()) {
            throw new IllegalStateException();
        }
        w1();
        r1 r1Var = (r1) this.f307w;
        s8.a aVar = r1Var.F;
        w0 w0Var = r1Var.A;
        aVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC2 = j3Var.c2();
        e0 e0Var = f0.S;
        if (jC2 < jCurrentTimeMillis - ((Long) e0Var.a(null)).longValue() || j3Var.c2() > ((Long) e0Var.a(null)).longValue() + jCurrentTimeMillis) {
            r1.g(w0Var);
            w0Var.E.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", w0.u1(j3Var.p()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j3Var.c2()));
        }
        byte[] bArrA = j3Var.a();
        try {
            a1 a1Var = this.f4215x.B;
            q4.P(a1Var);
            byte[] bArrY1 = a1Var.Y1(bArrA);
            r1.g(w0Var);
            w0Var.J.b(Integer.valueOf(bArrY1.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", j3Var.p());
            contentValues.put("bundle_end_timestamp", Long.valueOf(j3Var.c2()));
            contentValues.put("data", bArrY1);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (j3Var.p0()) {
                contentValues.put("retry_count", Integer.valueOf(j3Var.q0()));
            }
            try {
                if (b2().insert("queue", null, contentValues) == -1) {
                    r1.g(w0Var);
                    w0Var.B.b(w0.u1(j3Var.p()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e9) {
                r1.g(w0Var);
                w0Var.B.c(w0.u1(j3Var.p()), e9, "Error storing bundle. appId");
            }
        } catch (IOException e10) {
            r1.g(w0Var);
            w0Var.B.c(w0.u1(j3Var.p()), e10, "Data loss. Failed to serialize bundle. appId");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String u1() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.b2()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L37
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3d
        L22:
            r0 = move-exception
            goto L3d
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            java.lang.Object r3 = r6.f307w     // Catch: java.lang.Throwable -> L1a
            f9.r1 r3 = (f9.r1) r3     // Catch: java.lang.Throwable -> L1a
            f9.w0 r3 = r3.A     // Catch: java.lang.Throwable -> L1a
            f9.r1.g(r3)     // Catch: java.lang.Throwable -> L1a
            f9.u0 r3 = r3.B     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r2, r4)     // Catch: java.lang.Throwable -> L1a
        L37:
            if (r0 == 0) goto L3c
            r0.close()
        L3c:
            return r1
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n.u1():java.lang.String");
    }

    public final void v1(long j4) {
        m1();
        n1();
        try {
            if (b2().delete("queue", "rowid=?", new String[]{String.valueOf(j4)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.b(e9, "Failed to delete a bundle in a queue table");
            throw e9;
        }
    }

    public final void w1() {
        m1();
        n1();
        if (T1()) {
            q4 q4Var = this.f4215x;
            long jC = q4Var.D.A.c();
            r1 r1Var = (r1) this.f307w;
            r1Var.F.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jC) > ((Long) f0.N.a(null)).longValue()) {
                q4Var.D.A.e(jElapsedRealtime);
                m1();
                n1();
                if (T1()) {
                    SQLiteDatabase sQLiteDatabaseB2 = b2();
                    r1Var.F.getClass();
                    int iDelete = sQLiteDatabaseB2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) f0.S.a(null)).longValue())});
                    if (iDelete > 0) {
                        w0 w0Var = r1Var.A;
                        r1.g(w0Var);
                        w0Var.J.b(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    public final void x1(ArrayList arrayList) {
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        o8.u.g(arrayList);
        if (arrayList.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        if (T1()) {
            String strJoin = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (W1(sb2.toString(), null) > 0) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.E.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseB2 = b2();
                StringBuilder sb3 = new StringBuilder(string.length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseB2.execSQL(sb3.toString());
            } catch (SQLiteException e9) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.B.b(e9, "Error incrementing retry count. error");
            }
        }
    }

    public final void y1(Long l10) {
        r1 r1Var = (r1) this.f307w;
        m1();
        n1();
        if (T1()) {
            StringBuilder sb = new StringBuilder(l10.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l10);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (W1(sb.toString(), null) > 0) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.E.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseB2 = b2();
                r1Var.F.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l10.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l10);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseB2.execSQL(sb3.toString());
            } catch (SQLiteException e9) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.B.b(e9, "Error incrementing retry count. error");
            }
        }
    }

    public final Object z1(Cursor cursor, int i) {
        r1 r1Var = (r1) this.f307w;
        int type = cursor.getType(i);
        if (type == 0) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
            return null;
        }
        w0 w0Var3 = r1Var.A;
        r1.g(w0Var3);
        w0Var3.B.a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    @Override // f9.l4
    public final void p1() {
    }
}
