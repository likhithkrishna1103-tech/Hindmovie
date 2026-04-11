package q0;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c, f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10428u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10429v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10430w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10431x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Comparable f10432y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f10433z;

    public /* synthetic */ d() {
        this.f10428u = 0;
    }

    public static String d(ga.g gVar) {
        gVar.a();
        ga.j jVar = gVar.f5348c;
        String str = jVar.f5363e;
        if (str != null) {
            return str;
        }
        gVar.a();
        String str2 = jVar.f5360b;
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

    @Override // q0.f
    public ClipData a() {
        return (ClipData) this.f10429v;
    }

    public synchronized String b() {
        try {
            if (((String) this.f10432y) == null) {
                i();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f10432y;
    }

    @Override // q0.c
    public g build() {
        return new g(new d(this));
    }

    public synchronized String c() {
        try {
            if (((String) this.f10433z) == null) {
                i();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f10433z;
    }

    public PackageInfo e(String str) {
        try {
            return ((Context) this.f10429v).getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Failed to find package " + e10);
            return null;
        }
    }

    @Override // q0.f
    public int f() {
        return this.f10431x;
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
            int r0 = r5.f10431x     // Catch: java.lang.Throwable -> L27
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            monitor-exit(r5)
            goto L7f
        La:
            java.lang.Object r0 = r5.f10429v     // Catch: java.lang.Throwable -> L27
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
            boolean r3 = x7.b.d()     // Catch: java.lang.Throwable -> L27
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
            r5.f10431x = r1     // Catch: java.lang.Throwable -> L27
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
            r5.f10431x = r3     // Catch: java.lang.Throwable -> L27
            monitor-exit(r5)
            r0 = r3
            goto L7f
        L6a:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r4 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r4)     // Catch: java.lang.Throwable -> L27
            boolean r0 = x7.b.d()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L7a
            r5.f10431x = r3     // Catch: java.lang.Throwable -> L27
            goto L7c
        L7a:
            r5.f10431x = r1     // Catch: java.lang.Throwable -> L27
        L7c:
            int r0 = r5.f10431x     // Catch: java.lang.Throwable -> L27
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
        throw new UnsupportedOperationException("Method not decompiled: q0.d.g():boolean");
    }

    @Override // q0.f
    public ContentInfo h() {
        return null;
    }

    public synchronized void i() {
        PackageInfo packageInfoE = e(((Context) this.f10429v).getPackageName());
        if (packageInfoE != null) {
            this.f10432y = Integer.toString(packageInfoE.versionCode);
            this.f10433z = packageInfoE.versionName;
        }
    }

    @Override // q0.f
    public int j() {
        return this.f10430w;
    }

    @Override // q0.c
    public void o(Uri uri) {
        this.f10432y = uri;
    }

    @Override // q0.c
    public void setExtras(Bundle bundle) {
        this.f10433z = bundle;
    }

    public String toString() {
        String str;
        switch (this.f10428u) {
            case 1:
                Uri uri = (Uri) this.f10432y;
                StringBuilder sb2 = new StringBuilder("ContentInfoCompat{clip=");
                sb2.append(((ClipData) this.f10429v).getDescription());
                sb2.append(", source=");
                int i = this.f10430w;
                sb2.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb2.append(", flags=");
                int i10 = this.f10431x;
                sb2.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb2.append(str);
                return l4.a.o(sb2, ((Bundle) this.f10433z) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    @Override // q0.c
    public void u(int i) {
        this.f10431x = i;
    }

    public d(Context context) {
        this.f10428u = 2;
        this.f10431x = 0;
        this.f10429v = context;
    }

    public d(d dVar) {
        this.f10428u = 1;
        ClipData clipData = (ClipData) dVar.f10429v;
        clipData.getClass();
        this.f10429v = clipData;
        int i = dVar.f10430w;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i <= 5) {
            this.f10430w = i;
            int i10 = dVar.f10431x;
            if ((i10 & 1) == i10) {
                this.f10431x = i10;
                this.f10432y = (Uri) dVar.f10432y;
                this.f10433z = (Bundle) dVar.f10433z;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
