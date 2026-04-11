package ta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f12432g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12433h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bb.a f12434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ob.d f12437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o2.p f12438e;
    public b f;

    public v(Context context, String str, ob.d dVar, o2.p pVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f12435b = context;
        this.f12436c = str;
        this.f12437d = dVar;
        this.f12438e = pVar;
        this.f12434a = new bb.a();
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = f12432g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        String str2 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str2, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final u b(boolean z2) {
        String str;
        String str2 = null;
        if (Looper.getMainLooper().isCurrentThread()) {
            String str3 = "Must not be called on a main thread, was called on " + Thread.currentThread().getName() + '.';
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str3, null);
            }
        }
        ob.d dVar = this.f12437d;
        if (z2) {
            try {
                str = ((ob.a) t1.e(((ob.c) dVar).e(), 10000L, TimeUnit.MILLISECONDS)).f9480a;
            } catch (Exception e10) {
                Log.w("FirebaseCrashlytics", "Error getting Firebase authentication token.", e10);
                str = null;
            }
        } else {
            str = null;
        }
        try {
            str2 = (String) t1.e(((ob.c) dVar).d(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", e11);
        }
        return new u(str2, str);
    }

    public final synchronized b c() {
        String str;
        b bVar = this.f;
        if (bVar != null && (bVar.f12352b != null || !this.f12438e.a())) {
            return this.f;
        }
        qa.c cVar = qa.c.f11167a;
        cVar.e("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f12435b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        cVar.e("Cached Firebase Installation ID: " + string);
        if (this.f12438e.a()) {
            u uVarB = b(false);
            cVar.e("Fetched Firebase Installation ID: " + uVarB.f12430a);
            if (uVarB.f12430a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                uVarB = new u(str, null);
            }
            if (Objects.equals(uVarB.f12430a, string)) {
                this.f = new b(sharedPreferences.getString("crashlytics.installation.id", null), uVarB.f12430a, uVarB.f12431b);
            } else {
                this.f = new b(a(sharedPreferences, uVarB.f12430a), uVarB.f12430a, uVarB.f12431b);
            }
        } else if (string == null || !string.startsWith("SYN_")) {
            this.f = new b(a(sharedPreferences, "SYN_" + UUID.randomUUID().toString()), null, null);
        } else {
            this.f = new b(sharedPreferences.getString("crashlytics.installation.id", null), null, null);
        }
        cVar.e("Install IDs: " + this.f);
        return this.f;
    }

    public final String d() {
        String str;
        bb.a aVar = this.f12434a;
        Context context = this.f12435b;
        synchronized (aVar) {
            try {
                if (aVar.f1976a == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    aVar.f1976a = installerPackageName;
                }
                str = "".equals(aVar.f1976a) ? null : aVar.f1976a;
            } finally {
            }
        }
        return str;
    }
}
