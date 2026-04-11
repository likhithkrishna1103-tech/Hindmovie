package b2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements g, u3.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1727w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f1728x;

    public q(int i) {
        switch (i) {
            case 3:
                this.f1728x = new double[16];
                this.f1726v = -1;
                this.f1727w = -1;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.f1728x = new q[256];
                this.f1726v = 0;
                this.f1727w = 0;
                break;
            default:
                this.f1728x = new l4.c0(8);
                this.f1726v = 8000;
                this.f1727w = 8000;
                break;
        }
    }

    public static double e(q qVar) {
        double d10;
        int i = qVar.f1727w;
        int i10 = qVar.f1726v;
        int i11 = i - i10;
        int i12 = i11 + 1;
        int i13 = 1;
        if (i12 < 1) {
            qVar.getClass();
            throw new IllegalArgumentException("inclusionCount cannot be less than 1.");
        }
        if (i12 > (i - i10) + 1) {
            throw new IllegalArgumentException("inclusionCount cannot be greater than the inserted value count.");
        }
        double d11 = 0.0d;
        if (1 <= i12) {
            d10 = 0.0d;
            while (true) {
                d10 += (double) i13;
                if (i13 == i12) {
                    break;
                }
                i13++;
            }
        } else {
            d10 = 0.0d;
        }
        int i14 = qVar.f1727w;
        int i15 = i14 - i11;
        if (i15 <= i14) {
            while (true) {
                d11 += (((double) i12) / d10) * ((double[]) qVar.f1728x)[i14];
                i12--;
                if (i14 == i15) {
                    break;
                }
                i14--;
            }
        }
        return d11;
    }

    @Override // u3.c
    public int a() {
        return this.f1726v;
    }

    @Override // u3.c
    public int b() {
        return this.f1727w;
    }

    @Override // u3.c
    public int c() {
        int i = this.f1726v;
        return i == -1 ? ((y1.t) this.f1728x).B() : i;
    }

    public void d(double d10) {
        int i = this.f1727w;
        int i10 = this.f1726v;
        if ((i - i10) + 1 == 5) {
            this.f1726v = i10 + 1;
        }
        double[] dArr = (double[]) this.f1728x;
        if (i == dArr.length - 1) {
            double[] dArr2 = new double[dArr.length * 2];
            int i11 = this.f1726v;
            int i12 = i - i11;
            System.arraycopy(dArr, i11, dArr2, 0, i12 + 1);
            this.f1728x = dArr2;
            this.f1726v = 0;
            this.f1727w = i12;
        }
        int i13 = this.f1727w + 1;
        this.f1727w = i13;
        if (i13 == 0) {
            this.f1726v = 0;
        }
        ((double[]) this.f1728x)[i13] = d10;
    }

    public synchronized int f() {
        PackageInfo packageInfoB;
        if (this.f1726v == 0) {
            try {
                packageInfoB = u8.b.a((Context) this.f1728x).b(0, "com.google.android.gms");
            } catch (PackageManager.NameNotFoundException e9) {
                Log.w("Metadata", "Failed to find package ".concat(e9.toString()));
                packageInfoB = null;
            }
            if (packageInfoB != null) {
                this.f1726v = packageInfoB.versionCode;
            }
        }
        return this.f1726v;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0025, B:14:0x0030, B:16:0x0037, B:18:0x0049, B:26:0x006a, B:21:0x0050, B:23:0x0063, B:29:0x006e, B:33:0x007d), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int g() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f1727w     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L7
            monitor-exit(r5)
            return r0
        L7:
            java.lang.Object r0 = r5.f1728x     // Catch: java.lang.Throwable -> L2e
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L2e
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            b7.e r0 = u8.b.a(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            android.content.Context r0 = r0.f1830a     // Catch: java.lang.Throwable -> L2e
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            int r0 = r0.checkPermission(r2, r3)     // Catch: java.lang.Throwable -> L2e
            r2 = -1
            r3 = 0
            if (r0 != r2) goto L30
            java.lang.String r0 = "Metadata"
            java.lang.String r1 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r3
        L2e:
            r0 = move-exception
            goto L81
        L30:
            boolean r0 = s8.b.d()     // Catch: java.lang.Throwable -> L2e
            r2 = 1
            if (r0 != 0) goto L50
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.gms"
            r0.setPackage(r4)     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r1.queryIntentServices(r0, r3)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L50
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L50
            goto L6a
        L50:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.gms"
            r0.setPackage(r4)     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r3)     // Catch: java.lang.Throwable -> L2e
            r1 = 2
            if (r0 == 0) goto L6e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L6e
            r2 = r1
        L6a:
            r5.f1727w = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L6e:
            java.lang.String r0 = "Metadata"
            java.lang.String r3 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = s8.b.d()     // Catch: java.lang.Throwable -> L2e
            if (r2 == r0) goto L7c
            goto L7d
        L7c:
            r2 = r1
        L7d:
            r5.f1727w = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L81:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.q.g():int");
    }

    @Override // b2.g
    public h h() {
        return new t(this.f1726v, this.f1727w, (l4.c0) this.f1728x);
    }

    public q(Context context, XmlResourceParser xmlResourceParser) {
        this.f1728x = new ArrayList();
        this.f1727w = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d0.r.State);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == d0.r.State_android_id) {
                this.f1726v = typedArrayObtainStyledAttributes.getResourceId(index, this.f1726v);
            } else if (index == d0.r.State_constraints) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1727w);
                this.f1727w = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new d0.n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
