package f9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.q8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4266v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ a7.a f4267w;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Context context) {
        this(context, "google_app_measurement.db");
        this.f4266v = 0;
        this.f4267w = nVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        switch (this.f4266v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n nVar = (n) this.f4267w;
                r1 r1Var = (r1) nVar.f307w;
                r1 r1Var2 = (r1) nVar.f307w;
                r1Var.getClass();
                s0 s0Var = nVar.A;
                if (s0Var.f4390w != 0) {
                    ((s8.a) s0Var.f4391x).getClass();
                    if (SystemClock.elapsedRealtime() - s0Var.f4390w < 3600000) {
                        throw new SQLiteException("Database open failed");
                    }
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException unused) {
                    ((s8.a) s0Var.f4391x).getClass();
                    s0Var.f4390w = SystemClock.elapsedRealtime();
                    w0 w0Var = r1Var2.A;
                    r1.g(w0Var);
                    w0Var.B.a("Opening the database failed, dropping and recreating it");
                    if (!r1Var2.f4363v.getDatabasePath("google_app_measurement.db").delete()) {
                        w0 w0Var2 = r1Var2.A;
                        r1.g(w0Var2);
                        w0Var2.B.b("google_app_measurement.db", "Failed to delete corrupted db file");
                    }
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        s0Var.f4390w = 0L;
                        return writableDatabase;
                    } catch (SQLiteException e9) {
                        w0 w0Var3 = r1Var2.A;
                        r1.g(w0Var3);
                        w0Var3.B.b(e9, "Failed to open freshly created database");
                        throw e9;
                    }
                }
            default:
                p0 p0Var = (p0) this.f4267w;
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e10) {
                    throw e10;
                } catch (SQLiteException unused2) {
                    r1 r1Var3 = (r1) p0Var.f307w;
                    w0 w0Var4 = r1Var3.A;
                    r1.g(w0Var4);
                    w0Var4.B.a("Opening the local database failed, dropping and recreating it");
                    if (!r1Var3.f4363v.getDatabasePath("google_app_measurement_local.db").delete()) {
                        w0 w0Var5 = r1Var3.A;
                        r1.g(w0Var5);
                        w0Var5.B.b("google_app_measurement_local.db", "Failed to delete corrupted local db file");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e11) {
                        w0 w0Var6 = ((r1) p0Var.f307w).A;
                        r1.g(w0Var6);
                        w0Var6.B.b(e11, "Failed to open local database. Events will bypass local storage");
                        return null;
                    }
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.f4266v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w0 w0Var = ((r1) ((n) this.f4267w).f307w).A;
                r1.g(w0Var);
                h2.f(w0Var, sQLiteDatabase);
                break;
            default:
                w0 w0Var2 = ((r1) ((p0) this.f4267w).f307w).A;
                r1.g(w0Var2);
                h2.f(w0Var2, sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        int i11 = this.f4266v;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        switch (this.f4266v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                r1 r1Var = (r1) ((n) this.f4267w).f307w;
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                h2.d(w0Var, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", n.B);
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "events_snapshot", "CREATE TABLE IF NOT EXISTS events_snapshot ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, last_bundled_timestamp INTEGER, last_bundled_day INTEGER, last_sampled_complex_event_id INTEGER, last_sampling_rate INTEGER, last_exempt_from_sampling INTEGER, current_session_count INTEGER, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp,last_bundled_timestamp,last_bundled_day,last_sampled_complex_event_id,last_sampling_rate,last_exempt_from_sampling,current_session_count", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", n.D);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", n.E);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", n.G);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", n.F);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", n.H);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", n.I);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", n.J);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", n.K);
                q8.a();
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "trigger_uris", "CREATE TABLE IF NOT EXISTS trigger_uris ( app_id TEXT NOT NULL, trigger_uri TEXT NOT NULL, timestamp_millis INTEGER NOT NULL, source INTEGER NOT NULL);", "app_id,trigger_uri,source,timestamp_millis", n.L);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "upload_queue", "CREATE TABLE IF NOT EXISTS upload_queue ( app_id TEXT NOT NULL, upload_uri TEXT NOT NULL, upload_headers TEXT NOT NULL, upload_type INTEGER NOT NULL, measurement_batch BLOB NOT NULL, retry_count INTEGER NOT NULL, creation_timestamp INTEGER NOT NULL );", "app_id,upload_uri,upload_headers,upload_type,measurement_batch,retry_count,creation_timestamp", n.C);
                r1.g(w0Var2);
                h2.d(w0Var2, sQLiteDatabase, "no_data_mode_events", "CREATE TABLE IF NOT EXISTS no_data_mode_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, data BLOB NOT NULL, timestamp_millis INTEGER NOT NULL);", "app_id,name,data,timestamp_millis", null);
                break;
            default:
                w0 w0Var3 = ((r1) ((p0) this.f4267w).f307w).A;
                r1.g(w0Var3);
                h2.d(w0Var3, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", p0.A);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        int i11 = this.f4266v;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(p0 p0Var, Context context) {
        this(context, "google_app_measurement_local.db");
        this.f4266v = 1;
        this.f4267w = p0Var;
    }

    public m(Context context, String str) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private final void a(SQLiteDatabase sQLiteDatabase, int i, int i10) {
    }

    private final void g(SQLiteDatabase sQLiteDatabase, int i, int i10) {
    }

    private final void q(SQLiteDatabase sQLiteDatabase, int i, int i10) {
    }

    private final void s(SQLiteDatabase sQLiteDatabase, int i, int i10) {
    }
}
