package a0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import q0.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements q0.p, q3.c, v1.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f59u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f60v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f61w;

    public g(Context context, XmlResourceParser xmlResourceParser) {
        this.f61w = new ArrayList();
        this.f60v = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), s.State);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == s.State_android_id) {
                this.f59u = typedArrayObtainStyledAttributes.getResourceId(index, this.f59u);
            } else if (index == s.State_constraints) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f60v);
                this.f60v = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new o().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static double e(g gVar) {
        double d10;
        int i = gVar.f60v;
        int i10 = gVar.f59u;
        int i11 = i - i10;
        int i12 = i11 + 1;
        int i13 = 1;
        if (i12 < 1) {
            gVar.getClass();
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
        int i14 = gVar.f60v;
        int i15 = i14 - i11;
        if (i15 <= i14) {
            while (true) {
                d11 += (((double) i12) / d10) * ((double[]) gVar.f61w)[i14];
                i12--;
                if (i14 == i15) {
                    break;
                }
                i14--;
            }
        }
        return d11;
    }

    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        View view2 = (View) this.f61w;
        int i = r1Var.f10492a.f(519).f6162b;
        int i10 = this.f59u;
        if (i10 >= 0) {
            view2.getLayoutParams().height = i10 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f60v + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return r1Var;
    }

    @Override // q3.c
    public int a() {
        return this.f59u;
    }

    @Override // q3.c
    public int b() {
        return this.f60v;
    }

    @Override // q3.c
    public int c() {
        int i = this.f59u;
        return i == -1 ? ((s1.u) this.f61w).B() : i;
    }

    public void d(double d10) {
        int i = this.f60v;
        int i10 = this.f59u;
        if ((i - i10) + 1 == 5) {
            this.f59u = i10 + 1;
        }
        double[] dArr = (double[]) this.f61w;
        if (i == dArr.length - 1) {
            double[] dArr2 = new double[dArr.length * 2];
            int i11 = this.f59u;
            int i12 = i - i11;
            System.arraycopy(dArr, i11, dArr2, 0, i12 + 1);
            this.f61w = dArr2;
            this.f59u = 0;
            this.f60v = i12;
        }
        int i13 = this.f60v + 1;
        this.f60v = i13;
        if (i13 == 0) {
            this.f59u = 0;
        }
        ((double[]) this.f61w)[i13] = d10;
    }

    public synchronized int f() {
        PackageInfo packageInfoC;
        if (this.f59u == 0) {
            try {
                packageInfoC = z7.b.a((Context) this.f61w).c("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.w("Metadata", "Failed to find package ".concat(e10.toString()));
                packageInfoC = null;
            }
            if (packageInfoC != null) {
                this.f59u = packageInfoC.versionCode;
            }
        }
        return this.f59u;
    }

    @Override // v1.g
    public v1.h g() {
        return new v1.q(this.f59u, this.f60v, (p2.c) this.f61w);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0025, B:14:0x0030, B:16:0x0037, B:18:0x0049, B:26:0x006a, B:21:0x0050, B:23:0x0063, B:29:0x006e, B:33:0x007d), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int h() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f60v     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L7
            monitor-exit(r5)
            return r0
        L7:
            java.lang.Object r0 = r5.f61w     // Catch: java.lang.Throwable -> L2e
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L2e
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            wc.b r0 = z7.b.a(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            android.content.Context r0 = r0.f14093a     // Catch: java.lang.Throwable -> L2e
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
            boolean r0 = x7.b.d()     // Catch: java.lang.Throwable -> L2e
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
            r5.f60v = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L6e:
            java.lang.String r0 = "Metadata"
            java.lang.String r3 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = x7.b.d()     // Catch: java.lang.Throwable -> L2e
            if (r2 == r0) goto L7c
            goto L7d
        L7c:
            r2 = r1
        L7d:
            r5.f60v = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L81:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.g.h():int");
    }

    public g(int i) {
        switch (i) {
            case 3:
                this.f61w = new double[16];
                this.f59u = -1;
                this.f60v = -1;
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f61w = new p2.c(21);
                this.f59u = 8000;
                this.f60v = 8000;
                break;
            default:
                this.f61w = new g[256];
                this.f59u = 0;
                this.f60v = 0;
                break;
        }
    }
}
