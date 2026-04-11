package k8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.s5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends t3 {
    public static final String[] A = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] B = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] C = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;"};
    public static final String[] D = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] E = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] F = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] G = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] H = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public static final String[] I = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    public static final String[] J = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f7235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final af.a f7236z;

    public i(x3 x3Var) {
        super(x3Var);
        this.f7236z = new af.a(((k1) this.f2454v).H);
        this.f7235y = new m(this, ((k1) this.f2454v).f7282u);
    }

    public static void K1(ContentValues contentValues, Object obj) {
        t7.v.d("value");
        t7.v.h(obj);
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A1(java.lang.String r3, java.lang.String[] r4, long r5) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.w1()
            r1 = 0
            android.database.Cursor r1 = r0.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            if (r4 == 0) goto L1c
            r4 = 0
            long r3 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            r1.close()
            return r3
        L18:
            r3 = move-exception
            goto L2c
        L1a:
            r4 = move-exception
            goto L20
        L1c:
            r1.close()
            return r5
        L20:
            k8.p0 r5 = r2.g()     // Catch: java.lang.Throwable -> L18
            k8.r0 r5 = r5.A     // Catch: java.lang.Throwable -> L18
            java.lang.String r6 = "Database error"
            r5.b(r3, r4, r6)     // Catch: java.lang.Throwable -> L18
            throw r4     // Catch: java.lang.Throwable -> L18
        L2c:
            if (r1 == 0) goto L31
            r1.close()
        L31:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.A1(java.lang.String, java.lang.String[], long):long");
    }

    public final void A2() {
        t1();
        w1().endTransaction();
    }

    public final Object B1(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            g().A.d("Loaded invalid null value from database");
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
            g().A.c(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
            return null;
        }
        g().A.d("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final void B2() {
        k1 k1Var = (k1) this.f2454v;
        p1();
        t1();
        if (b2()) {
            x3 x3Var = this.f7443w;
            long jC = x3Var.C.f7262z.c();
            k1Var.H.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jC) > ((Long) w.A.a(null)).longValue()) {
                x3Var.C.f7262z.d(jElapsedRealtime);
                p1();
                t1();
                if (b2()) {
                    SQLiteDatabase sQLiteDatabaseW1 = w1();
                    k1Var.H.getClass();
                    int iDelete = sQLiteDatabaseW1.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) w.F.a(null)).longValue())});
                    if (iDelete > 0) {
                        g().I.c(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String C1(long r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r3.p1()
            r3.t1()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.w1()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 != 0) goto L33
            k8.p0 r5 = r3.g()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            k8.r0 r5 = r5.I     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r1 = "No expired configs for apps with pending events"
            r5.d(r1)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r4.close()
            return r0
        L2e:
            r5 = move-exception
            r0 = r4
            goto L51
        L31:
            r5 = move-exception
            goto L40
        L33:
            r5 = 0
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r4.close()
            return r5
        L3c:
            r5 = move-exception
            goto L51
        L3e:
            r5 = move-exception
            r4 = r0
        L40:
            k8.p0 r1 = r3.g()     // Catch: java.lang.Throwable -> L2e
            k8.r0 r1 = r1.A     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "Error selecting expired configs"
            r1.c(r5, r2)     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L50
            r4.close()
        L50:
            return r0
        L51:
            if (r0 == 0) goto L56
            r0.close()
        L56:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.C1(long):java.lang.String");
    }

    public final void C2() {
        t1();
        w1().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String D1(java.lang.String r4, java.lang.String[] r5) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r0 = r3.w1()
            r1 = 0
            android.database.Cursor r1 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            boolean r5 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            if (r5 == 0) goto L1c
            r5 = 0
            java.lang.String r4 = r1.getString(r5)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            r1.close()
            return r4
        L18:
            r4 = move-exception
            goto L2e
        L1a:
            r5 = move-exception
            goto L22
        L1c:
            r1.close()
            java.lang.String r4 = ""
            return r4
        L22:
            k8.p0 r0 = r3.g()     // Catch: java.lang.Throwable -> L18
            k8.r0 r0 = r0.A     // Catch: java.lang.Throwable -> L18
            java.lang.String r2 = "Database error"
            r0.b(r4, r5, r2)     // Catch: java.lang.Throwable -> L18
            throw r5     // Catch: java.lang.Throwable -> L18
        L2e:
            if (r1 == 0) goto L33
            r1.close()
        L33:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.D1(java.lang.String, java.lang.String[]):java.lang.String");
    }

    public final List E1(int i, int i10, String str) {
        byte[] bArrE2;
        long jW;
        long jW2;
        p1();
        t1();
        int i11 = 1;
        t7.v.a(i > 0);
        t7.v.a(i10 > 0);
        t7.v.d(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = w1().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List list = Collections.EMPTY_LIST;
                    cursorQuery.close();
                    return list;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j5 = cursorQuery.getLong(0);
                    try {
                        bArrE2 = q1().e2(cursorQuery.getBlob(i11));
                    } catch (IOException e10) {
                        g().A.b(p0.v1(str), e10, "Failed to unzip queued bundle. appId");
                    }
                    if (!arrayList.isEmpty() && bArrE2.length + length > i10) {
                        break;
                    }
                    try {
                        com.google.android.gms.internal.measurement.m3 m3Var = (com.google.android.gms.internal.measurement.m3) s0.D1(com.google.android.gms.internal.measurement.n3.a2(), bArrE2);
                        if (!arrayList.isEmpty()) {
                            com.google.android.gms.internal.measurement.n3 n3Var = (com.google.android.gms.internal.measurement.n3) ((Pair) arrayList.get(0)).first;
                            com.google.android.gms.internal.measurement.n3 n3Var2 = (com.google.android.gms.internal.measurement.n3) m3Var.c();
                            if (!n3Var.F().equals(n3Var2.F()) || !n3Var.E().equals(n3Var2.E()) || n3Var.V() != n3Var2.V() || !n3Var.G().equals(n3Var2.G())) {
                                break;
                            }
                            Iterator it = n3Var.T().iterator();
                            while (true) {
                                jW = -1;
                                if (!it.hasNext()) {
                                    jW2 = -1;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.u3 u3Var = (com.google.android.gms.internal.measurement.u3) it.next();
                                if ("_npa".equals(u3Var.A())) {
                                    jW2 = u3Var.w();
                                    break;
                                }
                            }
                            Iterator it2 = n3Var2.T().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                com.google.android.gms.internal.measurement.u3 u3Var2 = (com.google.android.gms.internal.measurement.u3) it2.next();
                                if ("_npa".equals(u3Var2.A())) {
                                    jW = u3Var2.w();
                                    break;
                                }
                            }
                            if (jW2 != jW) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            int i12 = cursorQuery.getInt(2);
                            m3Var.e();
                            com.google.android.gms.internal.measurement.n3.o1((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, i12);
                        }
                        length += bArrE2.length;
                        arrayList.add(Pair.create((com.google.android.gms.internal.measurement.n3) m3Var.c(), Long.valueOf(j5)));
                    } catch (IOException e11) {
                        g().A.b(p0.v1(str), e11, "Failed to merge queued bundle. appId");
                    }
                    if (!cursorQuery.moveToNext() || length > i10) {
                        break;
                    }
                    i11 = 1;
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e12) {
                g().A.b(p0.v1(str), e12, "Error querying bundles. appId");
                List list2 = Collections.EMPTY_LIST;
                if (0 != 0) {
                    cursor.close();
                }
                return list2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List F1(String str, String str2, String str3) {
        t7.v.d(str);
        p1();
        t1();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb2.append(" and name glob ?");
        }
        return G1(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        g().A.c(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List G1(java.lang.String r21, java.lang.String[] r22) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.G1(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final k H1(long j5, String str, long j8, boolean z2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        t7.v.d(str);
        p1();
        t1();
        String[] strArr = {str};
        k kVar = new k();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseW1 = w1();
                Cursor cursorQuery = sQLiteDatabaseW1.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    g().D.c(p0.v1(str), "Not updating daily counts, app is not known. appId");
                    cursorQuery.close();
                    return kVar;
                }
                if (cursorQuery.getLong(0) == j5) {
                    kVar.f7271b = cursorQuery.getLong(1);
                    kVar.f7270a = cursorQuery.getLong(2);
                    kVar.f7272c = cursorQuery.getLong(3);
                    kVar.f7273d = cursorQuery.getLong(4);
                    kVar.f7274e = cursorQuery.getLong(5);
                    kVar.f = cursorQuery.getLong(6);
                    kVar.f7275g = cursorQuery.getLong(7);
                }
                if (z2) {
                    kVar.f7271b += j8;
                }
                if (z10) {
                    kVar.f7270a += j8;
                }
                if (z11) {
                    kVar.f7272c += j8;
                }
                if (z12) {
                    kVar.f7273d += j8;
                }
                if (z13) {
                    kVar.f7274e += j8;
                }
                if (z14) {
                    kVar.f += j8;
                }
                if (z15) {
                    kVar.f7275g += j8;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j5));
                contentValues.put("daily_public_events_count", Long.valueOf(kVar.f7270a));
                contentValues.put("daily_events_count", Long.valueOf(kVar.f7271b));
                contentValues.put("daily_conversions_count", Long.valueOf(kVar.f7272c));
                contentValues.put("daily_error_events_count", Long.valueOf(kVar.f7273d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(kVar.f7274e));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(kVar.f));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(kVar.f7275g));
                sQLiteDatabaseW1.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return kVar;
            } catch (SQLiteException e10) {
                g().A.b(p0.v1(str), e10, "Error updating daily counts. appId");
                if (0 != 0) {
                    cursor.close();
                }
                return kVar;
            }
        } finally {
        }
    }

    public final k I1(long j5, String str, boolean z2, boolean z10, boolean z11, boolean z12) {
        return H1(j5, str, 1L, false, false, z2, false, z10, z11, z12);
    }

    public final void J1(ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseW1 = w1();
            if (contentValues.getAsString("app_id") == null) {
                g().C.c(p0.v1("app_id"), "Value of the primary key is not set.");
            } else if (sQLiteDatabaseW1.update("consent_settings", contentValues, "app_id = ?", new String[]{r3}) == 0 && sQLiteDatabaseW1.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                g().A.b(p0.v1("consent_settings"), p0.v1("app_id"), "Failed to insert/update table (got -1). key");
            }
        } catch (SQLiteException e10) {
            g().A.e("Error storing into table. key", p0.v1("consent_settings"), p0.v1("app_id"), e10);
        }
    }

    public final void L1(com.google.android.gms.internal.measurement.n3 n3Var, boolean z2) {
        p1();
        t1();
        t7.v.d(n3Var.c2());
        if (!n3Var.s0()) {
            throw new IllegalStateException();
        }
        B2();
        ((k1) this.f2454v).H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jI1 = n3Var.I1();
        f0 f0Var = w.F;
        if (jI1 < jCurrentTimeMillis - ((Long) f0Var.a(null)).longValue() || n3Var.I1() > ((Long) f0Var.a(null)).longValue() + jCurrentTimeMillis) {
            g().D.e("Storing bundle outside of the max uploading time span. appId, now, timestamp", p0.v1(n3Var.c2()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(n3Var.I1()));
        }
        try {
            byte[] bArrC2 = q1().c2(n3Var.c());
            g().I.c(Integer.valueOf(bArrC2.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", n3Var.c2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(n3Var.I1()));
            contentValues.put("data", bArrC2);
            contentValues.put("has_realtime", Integer.valueOf(z2 ? 1 : 0));
            if (n3Var.z0()) {
                contentValues.put("retry_count", Integer.valueOf(n3Var.h1()));
            }
            try {
                if (w1().insert("queue", null, contentValues) == -1) {
                    g().A.c(p0.v1(n3Var.c2()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e10) {
                g().A.b(p0.v1(n3Var.c2()), e10, "Error storing bundle. appId");
            }
        } catch (IOException e11) {
            g().A.b(p0.v1(n3Var.c2()), e11, "Data loss. Failed to serialize bundle. appId");
        }
    }

    public final void M1(Long l10) {
        p1();
        t1();
        l9.a();
        if (((k1) this.f2454v).A.A1(null, w.B0) && b2()) {
            if (e2("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l10 + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                g().D.d("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                w1().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l10 + " AND retry_count < 2147483647");
            } catch (SQLiteException e10) {
                g().A.c(e10, "Error incrementing retry count. error");
            }
        }
    }

    public final void N1(String str, Bundle bundle) {
        t7.v.h(bundle);
        p1();
        t1();
        String str2 = str;
        l lVar = new l(this, str);
        List<j> listA = lVar.a();
        while (!listA.isEmpty()) {
            for (j jVar : listA) {
                s0 s0VarQ1 = q1();
                com.google.android.gms.internal.measurement.f3 f3Var = jVar.f7252d;
                Bundle bundle2 = new Bundle();
                for (com.google.android.gms.internal.measurement.i3 i3Var : f3Var.C()) {
                    if (i3Var.F()) {
                        bundle2.putDouble(i3Var.C(), i3Var.n());
                    } else if (i3Var.G()) {
                        bundle2.putFloat(i3Var.C(), i3Var.u());
                    } else if (i3Var.H()) {
                        bundle2.putLong(i3Var.C(), i3Var.z());
                    } else if (i3Var.J()) {
                        bundle2.putString(i3Var.C(), i3Var.D());
                    } else if (i3Var.E().isEmpty()) {
                        s0VarQ1.g().A.c(i3Var, "Unexpected parameter type for parameter");
                    } else {
                        bundle2.putParcelableArray(i3Var.C(), s0.d2((s5) i3Var.E()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                if (string == null) {
                    string = "";
                }
                o1().H1(bundle2, bundle);
                d2.i iVar = new d2.i((k1) this.f2454v, string, str2, f3Var.B(), f3Var.z(), f3Var.y(), bundle2);
                long j5 = jVar.f7249a;
                long j8 = jVar.f7250b;
                boolean z2 = jVar.f7251c;
                p1();
                t1();
                String str3 = (String) iVar.f3731d;
                t7.v.d(str3);
                byte[] bArrC = q1().B1(iVar).c();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put("name", (String) iVar.f3732e);
                contentValues.put("timestamp", Long.valueOf(iVar.f3729b));
                contentValues.put("metadata_fingerprint", Long.valueOf(j8));
                contentValues.put("data", bArrC);
                contentValues.put("realtime", Integer.valueOf(z2 ? 1 : 0));
                try {
                    long jUpdate = w1().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j5)});
                    if (jUpdate != 1) {
                        g().A.b(p0.v1(str3), Long.valueOf(jUpdate), "Failed to update raw event. appId, updatedRows");
                    }
                } catch (SQLiteException e10) {
                    g().A.b(p0.v1(str3), e10, "Error updating raw event. appId");
                }
                str2 = str;
            }
            listA = lVar.a();
            str2 = str;
        }
    }

    public final void O1(String str, com.google.android.gms.internal.measurement.l3 l3Var, String str2, Map map, int i) {
        int iDelete;
        p1();
        t1();
        t7.v.h(l3Var);
        t7.v.d(str);
        l9.a();
        k1 k1Var = (k1) this.f2454v;
        e eVar = k1Var.A;
        x7.a aVar = k1Var.H;
        if (eVar.A1(null, w.B0)) {
            p1();
            t1();
            if (b2()) {
                x3 x3Var = this.f7443w;
                long jC = x3Var.C.A.c();
                aVar.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (Math.abs(jElapsedRealtime - jC) > ((Long) w.A.a(null)).longValue()) {
                    x3Var.C.A.d(jElapsedRealtime);
                    p1();
                    t1();
                    if (b2() && (iDelete = w1().delete("upload_queue", c2(), new String[0])) > 0) {
                        g().I.c(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
            byte[] bArrC = l3Var.c();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("measurement_batch", bArrC);
            contentValues.put("upload_uri", str2);
            StringBuilder sb2 = new StringBuilder();
            int size = arrayList.size();
            if (size > 0) {
                sb2.append((CharSequence) arrayList.get(0));
                int i10 = 1;
                while (i10 < size) {
                    sb2.append((CharSequence) "\r\n");
                    Object obj = arrayList.get(i10);
                    i10++;
                    sb2.append((CharSequence) obj);
                }
            }
            contentValues.put("upload_headers", sb2.toString());
            contentValues.put("upload_type", Integer.valueOf(v.e.c(i)));
            aVar.getClass();
            contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            try {
                if (w1().insert("upload_queue", null, contentValues) == -1) {
                    g().A.c(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
                }
            } catch (SQLiteException e10) {
                g().A.b(str, e10, "Error storing MeasurementBatch to upload_queue. appId");
            }
        }
    }

    public final void P1(String str, Long l10, long j5, com.google.android.gms.internal.measurement.f3 f3Var) {
        p1();
        t1();
        t7.v.h(f3Var);
        t7.v.d(str);
        byte[] bArrC = f3Var.c();
        g().I.b(((k1) this.f2454v).G.b(str), Integer.valueOf(bArrC.length), "Saving complex main event, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j5));
        contentValues.put("main_event", bArrC);
        try {
            if (w1().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                g().A.c(p0.v1(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing complex main event. appId");
        }
    }

    public final void Q1(String str, String str2) {
        t7.v.d(str);
        t7.v.d(str2);
        p1();
        t1();
        try {
            w1().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            g().A.e("Error deleting conditional property", p0.v1(str), ((k1) this.f2454v).G.g(str2), e10);
        }
    }

    public final void R1(String str, s sVar) {
        t7.v.h(sVar);
        p1();
        t1();
        ContentValues contentValues = new ContentValues();
        String str2 = sVar.f7407a;
        contentValues.put("app_id", str2);
        contentValues.put("name", sVar.f7408b);
        contentValues.put("lifetime_count", Long.valueOf(sVar.f7409c));
        contentValues.put("current_bundle_count", Long.valueOf(sVar.f7410d));
        contentValues.put("last_fire_timestamp", Long.valueOf(sVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(sVar.f7412g));
        contentValues.put("last_bundled_day", sVar.f7413h);
        contentValues.put("last_sampled_complex_event_id", sVar.i);
        contentValues.put("last_sampling_rate", sVar.f7414j);
        contentValues.put("current_session_count", Long.valueOf(sVar.f7411e));
        Boolean bool = sVar.f7415k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (w1().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                g().A.c(p0.v1(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str2), e10, "Error storing event aggregates. appId");
        }
    }

    public final void S1(String str, z1 z1Var) {
        t7.v.h(str);
        p1();
        t1();
        i2(str, r2(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", z1Var.m());
        J1(contentValues);
    }

    public final void T1(String str, r3 r3Var) {
        p1();
        t1();
        t7.v.d(str);
        ((k1) this.f2454v).H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j5 = r3Var.f7405v;
        f0 f0Var = w.f7485i0;
        if (j5 < jCurrentTimeMillis - ((Long) f0Var.a(null)).longValue() || j5 > ((Long) f0Var.a(null)).longValue() + jCurrentTimeMillis) {
            g().D.e("Storing trigger URI outside of the max retention time span. appId, now, timestamp", p0.v1(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j5));
        }
        g().I.d("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", r3Var.f7404u);
        contentValues.put("source", Integer.valueOf(r3Var.f7406w));
        contentValues.put("timestamp_millis", Long.valueOf(j5));
        try {
            if (w1().insert("trigger_uris", null, contentValues) == -1) {
                g().A.c(p0.v1(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing trigger URI. appId");
        }
    }

    public final void U1(List list) {
        p1();
        t1();
        t7.v.h(list);
        if (((ArrayList) list).size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        if (b2()) {
            String strN = e6.j.n("(", TextUtils.join(",", list), ")");
            if (e2("SELECT COUNT(1) FROM queue WHERE rowid IN " + strN + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                g().D.d("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                w1().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + strN + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                g().A.c(e10, "Error incrementing retry count. error");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V1(k8.g0 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.V1(k8.g0, boolean):void");
    }

    public final boolean W1(d2.i iVar, long j5, boolean z2) {
        p1();
        t1();
        String str = (String) iVar.f3731d;
        t7.v.d(str);
        byte[] bArrC = q1().B1(iVar).c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("name", (String) iVar.f3732e);
        contentValues.put("timestamp", Long.valueOf(iVar.f3729b));
        contentValues.put("metadata_fingerprint", Long.valueOf(j5));
        contentValues.put("data", bArrC);
        contentValues.put("realtime", Integer.valueOf(z2 ? 1 : 0));
        try {
            if (w1().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            g().A.c(p0.v1(str), "Failed to insert raw event (got -1). appId");
            return false;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing raw event. appId");
            return false;
        }
    }

    public final boolean X1(String str, int i, com.google.android.gms.internal.measurement.w1 w1Var) {
        t1();
        p1();
        t7.v.d(str);
        t7.v.h(w1Var);
        if (w1Var.u().isEmpty()) {
            g().D.e("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", p0.v1(str), Integer.valueOf(i), String.valueOf(w1Var.A() ? Integer.valueOf(w1Var.r()) : null));
            return false;
        }
        byte[] bArrC = w1Var.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", w1Var.A() ? Integer.valueOf(w1Var.r()) : null);
        contentValues.put("event_name", w1Var.u());
        contentValues.put("session_scoped", w1Var.B() ? Boolean.valueOf(w1Var.y()) : null);
        contentValues.put("data", bArrC);
        try {
            if (w1().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().A.c(p0.v1(str), "Failed to insert event filter (got -1). appId");
            return true;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing event filter. appId");
            return false;
        }
    }

    public final boolean Y1(String str, int i, com.google.android.gms.internal.measurement.c2 c2Var) {
        t1();
        p1();
        t7.v.d(str);
        t7.v.h(c2Var);
        if (c2Var.r().isEmpty()) {
            g().D.e("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", p0.v1(str), Integer.valueOf(i), String.valueOf(c2Var.v() ? Integer.valueOf(c2Var.n()) : null));
            return false;
        }
        byte[] bArrC = c2Var.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c2Var.v() ? Integer.valueOf(c2Var.n()) : null);
        contentValues.put("property_name", c2Var.r());
        contentValues.put("session_scoped", c2Var.w() ? Boolean.valueOf(c2Var.u()) : null);
        contentValues.put("data", bArrC);
        try {
            if (w1().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            g().A.c(p0.v1(str), "Failed to insert property filter (got -1). appId");
            return false;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing property filter. appId");
            return false;
        }
    }

    public final boolean Z1(d dVar) {
        p1();
        t1();
        String str = dVar.f7128u;
        t7.v.h(str);
        if (o2(str, dVar.f7130w.f7164v) == null && e2("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", dVar.f7129v);
        contentValues.put("name", dVar.f7130w.f7164v);
        Object objA = dVar.f7130w.a();
        t7.v.h(objA);
        K1(contentValues, objA);
        contentValues.put("active", Boolean.valueOf(dVar.f7132y));
        contentValues.put("trigger_event_name", dVar.f7133z);
        contentValues.put("trigger_timeout", Long.valueOf(dVar.B));
        o1();
        contentValues.put("timed_out_event", h4.f2(dVar.A));
        contentValues.put("creation_timestamp", Long.valueOf(dVar.f7131x));
        o1();
        contentValues.put("triggered_event", h4.f2(dVar.C));
        contentValues.put("triggered_timestamp", Long.valueOf(dVar.f7130w.f7165w));
        contentValues.put("time_to_live", Long.valueOf(dVar.D));
        o1();
        contentValues.put("expired_event", h4.f2(dVar.E));
        try {
            if (w1().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            g().A.c(p0.v1(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing conditional user property");
            return true;
        }
    }

    public final boolean a2(f4 f4Var) {
        String str = f4Var.f7180b;
        p1();
        t1();
        String str2 = f4Var.f7179a;
        String str3 = f4Var.f7181c;
        if (o2(str2, str3) == null) {
            if (h4.v2(str3)) {
                if (e2("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str2}) >= Math.max(Math.min(((k1) this.f2454v).A.u1(str2, w.J), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str3) && e2("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str2, str}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("origin", str);
        contentValues.put("name", str3);
        contentValues.put("set_timestamp", Long.valueOf(f4Var.f7182d));
        K1(contentValues, f4Var.f7183e);
        try {
            if (w1().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            g().A.c(p0.v1(str2), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str2), e10, "Error storing user property. appId");
            return true;
        }
    }

    public final boolean b2() {
        return ((k1) this.f2454v).f7282u.getDatabasePath("google_app_measurement.db").exists();
    }

    public final String c2() {
        ((k1) this.f2454v).H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = ((Long) w.G.a(null)).longValue();
        StringBuilder sb2 = new StringBuilder("(upload_type = 1 AND (ABS(creation_timestamp - ");
        sb2.append(jCurrentTimeMillis);
        sb2.append(") > CAST(");
        String strN = l4.a.n(sb2, jLongValue, " AS INTEGER)))");
        long jLongValue2 = ((Long) w.F.a(null)).longValue();
        StringBuilder sb3 = new StringBuilder("(upload_type != 1 AND (ABS(creation_timestamp - ");
        sb3.append(jCurrentTimeMillis);
        sb3.append(") > CAST(");
        return "(" + strN + " OR " + l4.a.n(sb3, jLongValue2, " AS INTEGER)))") + ")";
    }

    public final long d2(String str) {
        long jA1;
        t7.v.d(str);
        t7.v.d("first_open_count");
        p1();
        t1();
        SQLiteDatabase sQLiteDatabaseW1 = w1();
        sQLiteDatabaseW1.beginTransaction();
        long j5 = 0;
        try {
            try {
                jA1 = A1("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
            } catch (SQLiteException e10) {
                e = e10;
            }
            if (jA1 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (sQLiteDatabaseW1.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    g().A.b(p0.v1(str), "first_open_count", "Failed to insert column (got -1). appId");
                    return -1L;
                }
                jA1 = 0;
                g().A.e("Error inserting column. appId", p0.v1(str), "first_open_count", e);
                return j5;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + jA1));
                if (sQLiteDatabaseW1.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    g().A.b(p0.v1(str), "first_open_count", "Failed to update column (got 0). appId");
                    return -1L;
                }
                sQLiteDatabaseW1.setTransactionSuccessful();
                return jA1;
            } catch (SQLiteException e11) {
                e = e11;
                j5 = jA1;
            }
        } finally {
            sQLiteDatabaseW1.endTransaction();
        }
    }

    public final long e2(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = w1().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j5 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j5;
            } catch (SQLiteException e10) {
                g().A.b(str, e10, "Database error");
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
    
        g().A.c(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List f2(java.lang.String r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.f2(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void g2(String str, Bundle bundle) {
        p1();
        t1();
        byte[] bArrC = q1().B1(new d2.i((k1) this.f2454v, "", str, "dep", 0L, 0L, bundle)).c();
        g().I.b(((k1) this.f2454v).G.b(str), Integer.valueOf(bArrC.length), "Saving default event parameters, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrC);
        try {
            if (w1().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                g().A.c(p0.v1(str), "Failed to insert default event parameters (got -1). appId");
            }
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error storing default event parameters. appId");
        }
    }

    public final void h2(String str, ArrayList arrayList) {
        t7.v.d(str);
        t1();
        p1();
        SQLiteDatabase sQLiteDatabaseW1 = w1();
        try {
            long jE2 = e2("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, ((k1) this.f2454v).A.u1(str, w.I)));
            if (jE2 <= iMax) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                Integer num = (Integer) arrayList.get(i);
                if (num == null) {
                    return;
                }
                arrayList2.add(Integer.toString(num.intValue()));
            }
            sQLiteDatabaseW1.delete("audience_filter_values", e6.j.n("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", e6.j.n("(", TextUtils.join(",", arrayList2), ")"), " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(iMax)});
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Database error querying filters. appId");
        }
    }

    public final void i2(String str, z1 z1Var) {
        t7.v.h(str);
        t7.v.h(z1Var);
        p1();
        t1();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", z1Var.m());
        contentValues.put("consent_source", Integer.valueOf(z1Var.f7571b));
        J1(contentValues);
    }

    public final long j2(String str) {
        t7.v.d(str);
        p1();
        t1();
        return A1("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    public final long k2(String str) {
        t7.v.d(str);
        return A1("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0059: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:90), block:B:14:0x0059 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.d l2(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.l2(java.lang.String, java.lang.String):k8.d");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0130  */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.s m2(java.lang.String r29, java.lang.String r30, java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.m2(java.lang.String, java.lang.String, java.lang.String):k8.s");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b2: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:179), block:B:15:0x00b2 */
    /* JADX WARN: Removed duplicated region for block: B:141:0x042b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.g0 n2(java.lang.String r52) {
        /*
            Method dump skipped, instruction units count: 1071
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.n2(java.lang.String):k8.g0");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.f4 o2(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            t7.v.d(r11)
            t7.v.d(r12)
            r10.p1()
            r10.t1()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.w1()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L78
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L78
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L78
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L78
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L71
            if (r0 != 0) goto L34
            r2.close()
            return r1
        L34:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L71
            r0 = 1
            java.lang.Object r9 = r10.B1(r2, r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L71
            if (r9 != 0) goto L44
            r2.close()
            return r1
        L44:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L71
            k8.f4 r3 = new k8.f4     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L71
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            boolean r11 = r2.moveToNext()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            if (r11 == 0) goto L6d
            k8.p0 r11 = r10.g()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            k8.r0 r11 = r11.A     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            k8.q0 r0 = k8.p0.v1(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            r11.c(r0, r12)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L6a
            goto L6d
        L66:
            r0 = move-exception
            r11 = r0
            r1 = r2
            goto L9c
        L6a:
            r0 = move-exception
        L6b:
            r11 = r0
            goto L7d
        L6d:
            r2.close()
            return r3
        L71:
            r0 = move-exception
            r4 = r11
            r6 = r12
            goto L6b
        L75:
            r0 = move-exception
            r11 = r0
            goto L9c
        L78:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L7d:
            k8.p0 r12 = r10.g()     // Catch: java.lang.Throwable -> L66
            k8.r0 r12 = r12.A     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = "Error querying user property. appId"
            k8.q0 r3 = k8.p0.v1(r4)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r4 = r10.f2454v     // Catch: java.lang.Throwable -> L66
            k8.k1 r4 = (k8.k1) r4     // Catch: java.lang.Throwable -> L66
            k8.l0 r4 = r4.G     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = r4.g(r6)     // Catch: java.lang.Throwable -> L66
            r12.e(r0, r3, r4, r11)     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L9b
            r2.close()
        L9b:
            return r1
        L9c:
            if (r1 == 0) goto La1
            r1.close()
        La1:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.o2(java.lang.String, java.lang.String):k8.f4");
    }

    public final z1 p2(String str) {
        t7.v.h(str);
        p1();
        t1();
        return z1.d(D1("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}), 100);
    }

    public final void q2(String str, String str2) {
        t7.v.d(str);
        t7.v.d(str2);
        p1();
        t1();
        try {
            w1().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            g().A.e("Error deleting user property. appId", p0.v1(str), ((k1) this.f2454v).G.g(str2), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.z1 r2(java.lang.String r5) {
        /*
            r4 = this;
            t7.v.h(r5)
            r4.p1()
            r4.t1()
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.w1()     // Catch: java.lang.Throwable -> L44 android.database.sqlite.SQLiteException -> L46
            android.database.Cursor r5 = r2.rawQuery(r0, r5)     // Catch: java.lang.Throwable -> L44 android.database.sqlite.SQLiteException -> L46
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            if (r0 != 0) goto L32
            k8.p0 r0 = r4.g()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            k8.r0 r0 = r0.I     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            java.lang.String r2 = "No data found"
            r0.d(r2)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            r5.close()
            goto L58
        L2d:
            r0 = move-exception
            r1 = r5
            goto L5e
        L30:
            r0 = move-exception
            goto L48
        L32:
            r0 = 0
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            r2 = 1
            int r2 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            k8.z1 r1 = k8.z1.d(r0, r2)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L30
            r5.close()
            goto L58
        L44:
            r0 = move-exception
            goto L5e
        L46:
            r0 = move-exception
            r5 = r1
        L48:
            k8.p0 r2 = r4.g()     // Catch: java.lang.Throwable -> L2d
            k8.r0 r2 = r2.A     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "Error querying database."
            r2.c(r0, r3)     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L58
            r5.close()
        L58:
            if (r1 != 0) goto L5d
            k8.z1 r5 = k8.z1.f7569c
            return r5
        L5d:
            return r1
        L5e:
            if (r1 == 0) goto L63
            r1.close()
        L63:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.r2(java.lang.String):k8.z1");
    }

    public final void s2(String str, String str2) {
        t7.v.d(str2);
        p1();
        t1();
        try {
            w1().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str2), e10, "Error deleting snapshot. appId");
        }
    }

    public final d4 t2(String str) throws Throwable {
        d4 d4Var;
        Cursor cursorQuery;
        d4 d4Var2;
        t7.v.d(str);
        p1();
        t1();
        l9.a();
        Cursor cursor = null;
        d4Var = null;
        d4Var = null;
        d4 d4Var3 = null;
        if (!((k1) this.f2454v).A.A1(null, w.B0)) {
            return null;
        }
        try {
            cursorQuery = w1().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count"}, "app_id=? AND NOT " + c2(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(3);
                    try {
                        if (TextUtils.isEmpty(string)) {
                            g().H.d("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
                            cursorQuery.close();
                            return null;
                        }
                        try {
                            com.google.android.gms.internal.measurement.k3 k3Var = (com.google.android.gms.internal.measurement.k3) s0.D1(com.google.android.gms.internal.measurement.l3.v(), cursorQuery.getBlob(2));
                            int i = v.e.d(3)[cursorQuery.getInt(5)];
                            if ((i == 3 || i == 1) && cursorQuery.getInt(6) > 0) {
                                ArrayList arrayList = new ArrayList();
                                Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.l3) k3Var.f3052v).y()).iterator();
                                while (it.hasNext()) {
                                    com.google.android.gms.internal.measurement.m3 m3Var = (com.google.android.gms.internal.measurement.m3) ((com.google.android.gms.internal.measurement.n3) it.next()).k();
                                    int i10 = cursorQuery.getInt(6);
                                    m3Var.e();
                                    com.google.android.gms.internal.measurement.n3.o1((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, i10);
                                    arrayList.add((com.google.android.gms.internal.measurement.n3) m3Var.c());
                                }
                                k3Var.e();
                                com.google.android.gms.internal.measurement.l3.t((com.google.android.gms.internal.measurement.l3) k3Var.f3052v);
                                k3Var.e();
                                com.google.android.gms.internal.measurement.l3.s((com.google.android.gms.internal.measurement.l3) k3Var.f3052v, arrayList);
                            }
                            HashMap map = new HashMap();
                            String string2 = cursorQuery.getString(4);
                            if (string2 != null) {
                                String[] strArrSplit = string2.split("\r\n");
                                int length = strArrSplit.length;
                                int i11 = 0;
                                while (i11 < length) {
                                    String str2 = strArrSplit[i11];
                                    if (str2.isEmpty()) {
                                        break;
                                    }
                                    String[] strArrSplit2 = str2.split("=", 2);
                                    d4Var2 = d4Var3;
                                    try {
                                        if (strArrSplit2.length != 2) {
                                            g().A.c(str2, "Invalid upload header: ");
                                            break;
                                        }
                                        map.put(strArrSplit2[0], strArrSplit2[1]);
                                        i11++;
                                        d4Var3 = d4Var2;
                                    } catch (IOException e10) {
                                        e = e10;
                                        g().A.b(str, e, "Failed to queued MeasurementBatch from upload_queue. appId");
                                        cursorQuery.close();
                                        return d4Var2;
                                    }
                                }
                                d4Var2 = d4Var3;
                            } else {
                                d4Var2 = d4Var3;
                            }
                            long j5 = cursorQuery.getLong(0);
                            com.google.android.gms.internal.measurement.l3 l3Var = (com.google.android.gms.internal.measurement.l3) k3Var.c();
                            d4 d4Var4 = new d4();
                            d4Var4.f7139a = j5;
                            d4Var4.f7140b = l3Var;
                            d4Var4.f7141c = string;
                            d4Var4.f7142d = map;
                            d4Var4.f7143e = i;
                            cursorQuery.close();
                            return d4Var4;
                        } catch (IOException e11) {
                            e = e11;
                            d4Var2 = d4Var3;
                        }
                    } catch (SQLiteException e12) {
                        e = e12;
                        g().A.b(str, e, "Error to querying MeasurementBatch from upload_queue. appId");
                        if (cursorQuery == null) {
                            return d4Var;
                        }
                        cursorQuery.close();
                        return d4Var;
                    }
                } catch (SQLiteException e13) {
                    e = e13;
                    d4Var = null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e14) {
            e = e14;
            d4Var = null;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final List u2(String str) {
        String str2;
        t7.v.d(str);
        p1();
        t1();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = w1().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (true) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str3 = string2;
                    long j5 = cursorQuery.getLong(2);
                    Object objB1 = B1(cursorQuery, 3);
                    if (objB1 == null) {
                        g().A.c(p0.v1(str), "Read invalid user property value, ignoring it. appId");
                        str2 = str;
                    } else {
                        str2 = str;
                        try {
                            arrayList.add(new f4(str2, str3, string, j5, objB1));
                        } catch (SQLiteException e10) {
                            e = e10;
                        }
                    }
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    str = str2;
                }
            } finally {
            }
        } catch (SQLiteException e11) {
            e = e11;
            str2 = str;
        }
        g().A.b(p0.v1(str2), e, "Error querying user properties. appId");
        List list = Collections.EMPTY_LIST;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return list;
    }

    @Override // k8.t3
    public final boolean v1() {
        return false;
    }

    public final void v2() {
        t1();
        w1().beginTransaction();
    }

    public final SQLiteDatabase w1() {
        p1();
        try {
            return this.f7235y.getWritableDatabase();
        } catch (SQLiteException e10) {
            g().D.c(e10, "Error opening database");
            throw e10;
        }
    }

    public final void w2(String str) {
        p1();
        t1();
        try {
            w1().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e10) {
            g().A.c(e10, "Error clearing default event params");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String x1() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.w1()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L27
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L3a
        L1c:
            r2 = move-exception
            goto L29
        L1e:
            r0.close()
            return r1
        L22:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3a
        L27:
            r2 = move-exception
            r0 = r1
        L29:
            k8.p0 r3 = r6.g()     // Catch: java.lang.Throwable -> L1a
            k8.r0 r3 = r3.A     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.c(r2, r4)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            if (r0 == 0) goto L3f
            r0.close()
        L3f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.x1():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x2(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "events_snapshot"
            r12.s2(r0, r13)
            java.lang.String r1 = "name"
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.w1()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            java.lang.String r4 = "events"
            r11 = 0
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            java.lang.Object[] r1 = r1.toArray(r5)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            r5 = r1
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            if (r1 != 0) goto L33
            r2.close()
            return
        L33:
            java.lang.String r1 = r2.getString(r11)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            if (r1 == 0) goto L4a
            java.lang.String r3 = "events"
            k8.s r1 = r12.m2(r3, r13, r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            if (r1 == 0) goto L4a
            r12.R1(r0, r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            goto L4a
        L45:
            r0 = move-exception
            r13 = r0
            goto L69
        L48:
            r0 = move-exception
            goto L54
        L4a:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L48
            if (r1 != 0) goto L33
            r2.close()
            return
        L54:
            k8.p0 r1 = r12.g()     // Catch: java.lang.Throwable -> L45
            k8.r0 r1 = r1.A     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "Error creating snapshot. appId"
            k8.q0 r13 = k8.p0.v1(r13)     // Catch: java.lang.Throwable -> L45
            r1.b(r13, r0, r3)     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L68
            r2.close()
        L68:
            return
        L69:
            if (r2 == 0) goto L6e
            r2.close()
        L6e:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.x2(java.lang.String):void");
    }

    public final long y1(com.google.android.gms.internal.measurement.n3 n3Var) {
        p1();
        t1();
        t7.v.d(n3Var.c2());
        byte[] bArrC = n3Var.c();
        long jX1 = q1().x1(bArrC);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", n3Var.c2());
        contentValues.put("metadata_fingerprint", Long.valueOf(jX1));
        contentValues.put("metadata", bArrC);
        try {
            w1().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jX1;
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(n3Var.c2()), e10, "Error storing raw event metadata. appId");
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y2(java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i.y2(java.lang.String):void");
    }

    public final long z1(String str) {
        t7.v.d(str);
        p1();
        t1();
        try {
            return w1().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, ((k1) this.f2454v).A.u1(str, w.f7503q))))});
        } catch (SQLiteException e10) {
            g().A.b(p0.v1(str), e10, "Error deleting over the limit events. appId");
            return 0L;
        }
    }

    public final boolean z2(String str) {
        l9.a();
        return ((k1) this.f2454v).A.A1(null, w.B0) && e2(l4.a.m("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ", c2()), new String[]{str}) != 0;
    }
}
