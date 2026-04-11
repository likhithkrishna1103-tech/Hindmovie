package t0;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c, e {
    public Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11737v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f11738w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11739x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11740y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Comparable f11741z;

    public /* synthetic */ d() {
        this.f11737v = 0;
    }

    public static String c(ab.g gVar) {
        gVar.a();
        ab.j jVar = gVar.f392c;
        String str = jVar.f407e;
        if (str != null) {
            return str;
        }
        gVar.a();
        String str2 = jVar.f404b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String a() {
        try {
            if (((String) this.f11741z) == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f11741z;
    }

    public synchronized String b() {
        try {
            if (((String) this.A) == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.A;
    }

    @Override // t0.c
    public f build() {
        return new f(new d(this));
    }

    @Override // t0.e
    public int d() {
        return this.f11739x;
    }

    @Override // t0.e
    public ClipData e() {
        return (ClipData) this.f11738w;
    }

    public PackageInfo f(String str) {
        try {
            return ((Context) this.f11738w).getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e9) {
            Log.w("FirebaseMessaging", "Failed to find package " + e9);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001d, B:15:0x0029, B:17:0x002f, B:19:0x0041, B:21:0x0047, B:24:0x004c, B:26:0x005f, B:28:0x0065, B:31:0x006a, B:33:0x0077, B:35:0x007c, B:34:0x007a), top: B:42:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f11740y     // Catch: java.lang.Throwable -> L27
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            monitor-exit(r5)
            goto L7f
        La:
            java.lang.Object r0 = r5.f11738w     // Catch: java.lang.Throwable -> L27
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L27
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r4 = "com.google.android.gms"
            int r3 = r0.checkPermission(r3, r4)     // Catch: java.lang.Throwable -> L27
            r4 = -1
            if (r3 != r4) goto L29
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r3 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r5)
            r0 = r2
            goto L7f
        L27:
            r0 = move-exception
            goto L83
        L29:
            boolean r3 = s8.b.d()     // Catch: java.lang.Throwable -> L27
            if (r3 != 0) goto L4c
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L27
            java.util.List r3 = r0.queryIntentServices(r3, r2)     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L4c
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L27
            if (r3 <= 0) goto L4c
            r5.f11740y = r1     // Catch: java.lang.Throwable -> L27
            monitor-exit(r5)
            r0 = r1
            goto L7f
        L4c:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L27
            java.util.List r0 = r0.queryBroadcastReceivers(r3, r2)     // Catch: java.lang.Throwable -> L27
            r3 = 2
            if (r0 == 0) goto L6a
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L27
            if (r0 <= 0) goto L6a
            r5.f11740y = r3     // Catch: java.lang.Throwable -> L27
            monitor-exit(r5)
            r0 = r3
            goto L7f
        L6a:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r4 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r4)     // Catch: java.lang.Throwable -> L27
            boolean r0 = s8.b.d()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L7a
            r5.f11740y = r3     // Catch: java.lang.Throwable -> L27
            goto L7c
        L7a:
            r5.f11740y = r1     // Catch: java.lang.Throwable -> L27
        L7c:
            int r0 = r5.f11740y     // Catch: java.lang.Throwable -> L27
            monitor-exit(r5)
        L7f:
            if (r0 == 0) goto L82
            return r1
        L82:
            return r2
        L83:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L27
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.d.g():boolean");
    }

    public synchronized void h() {
        PackageInfo packageInfoF = f(((Context) this.f11738w).getPackageName());
        if (packageInfoF != null) {
            this.f11741z = Integer.toString(packageInfoF.versionCode);
            this.A = packageInfoF.versionName;
        }
    }

    @Override // t0.c
    public void i(Uri uri) {
        this.f11741z = uri;
    }

    @Override // t0.c
    public void l(int i) {
        this.f11740y = i;
    }

    @Override // t0.e
    public int r() {
        return this.f11740y;
    }

    @Override // t0.e
    public ContentInfo s() {
        return null;
    }

    @Override // t0.c
    public void setExtras(Bundle bundle) {
        this.A = bundle;
    }

    public String toString() {
        String str;
        switch (this.f11737v) {
            case 1:
                Uri uri = (Uri) this.f11741z;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.f11738w).getDescription());
                sb.append(", source=");
                int i = this.f11739x;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i10 = this.f11740y;
                sb.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return q4.a.q(sb, ((Bundle) this.A) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public d(Context context) {
        this.f11737v = 2;
        this.f11740y = 0;
        this.f11738w = context;
    }

    public d(d dVar) {
        this.f11737v = 1;
        ClipData clipData = (ClipData) dVar.f11738w;
        clipData.getClass();
        this.f11738w = clipData;
        int i = dVar.f11739x;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i <= 5) {
            this.f11739x = i;
            int i10 = dVar.f11740y;
            if ((i10 & 1) == i10) {
                this.f11740y = i10;
                this.f11741z = (Uri) dVar.f11741z;
                this.A = (Bundle) dVar.A;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
