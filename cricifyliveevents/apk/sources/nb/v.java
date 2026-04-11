package nb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f9008g = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9009h = Pattern.quote("/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d5.a f9010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic.d f9013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n8.k f9014e;
    public b f;

    public v(Context context, String str, ic.d dVar, n8.k kVar) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f9011b = context;
        this.f9012c = str;
        this.f9013d = dVar;
        this.f9014e = kVar;
        this.f9010a = new d5.a(2);
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = f9008g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        String str2 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str2, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    public final u b(boolean z10) {
        String str;
        String str2 = null;
        if (Looper.getMainLooper().isCurrentThread()) {
            String str3 = "Must not be called on a main thread, was called on " + Thread.currentThread().getName() + '.';
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str3, null);
            }
        }
        ic.d dVar = this.f9013d;
        if (z10) {
            try {
                str = ((ic.a) vf.g.c(((ic.c) dVar).e(), 10000L, TimeUnit.MILLISECONDS)).f6414a;
            } catch (Exception e9) {
                Log.w("FirebaseCrashlytics", "Error getting Firebase authentication token.", e9);
                str = null;
            }
        } else {
            str = null;
        }
        try {
            str2 = (String) vf.g.c(((ic.c) dVar).d(), 10000L, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", e10);
        }
        return new u(str2, str);
    }

    public final synchronized b c() {
        String str;
        b bVar = this.f;
        if (bVar != null && (bVar.f8926b != null || !this.f9014e.a())) {
            return this.f;
        }
        kb.c cVar = kb.c.f7396a;
        cVar.e("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f9011b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        cVar.e("Cached Firebase Installation ID: " + string);
        if (this.f9014e.a()) {
            u uVarB = b(false);
            cVar.e("Fetched Firebase Installation ID: " + uVarB.f9006a);
            if (uVarB.f9006a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                uVarB = new u(str, null);
            }
            if (Objects.equals(uVarB.f9006a, string)) {
                this.f = new b(sharedPreferences.getString("crashlytics.installation.id", null), uVarB.f9006a, uVarB.f9007b);
            } else {
                this.f = new b(a(sharedPreferences, uVarB.f9006a), uVarB.f9006a, uVarB.f9007b);
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
        d5.a aVar = this.f9010a;
        Context context = this.f9011b;
        synchronized (aVar) {
            try {
                if (aVar.f3391w == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    aVar.f3391w = installerPackageName;
                }
                str = "".equals(aVar.f3391w) ? null : aVar.f3391w;
            } finally {
            }
        }
        return str;
    }
}
