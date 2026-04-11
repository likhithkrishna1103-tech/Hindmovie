package pa;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.LandscapeActivity;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.SplashActivity;
import app.cricfy.tv.activities.SupportActivity;
import app.cricfy.tv.room.db.AppDatabase;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.textfield.TextInputLayout;
import g2.d0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10053v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f10054w;

    public /* synthetic */ c(int i, Object obj) {
        this.f10053v = i;
        this.f10054w = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005b A[Catch: all -> 0x0021, TryCatch #0 {, blocks: (B:6:0x0017, B:8:0x001b, B:15:0x0026, B:19:0x002c, B:25:0x0038, B:27:0x003c, B:29:0x0042, B:31:0x004c, B:33:0x0056, B:35:0x0067, B:34:0x005b, B:36:0x0069, B:38:0x007d, B:40:0x0084), top: B:48:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f10054w
            y1.r r0 = (y1.r) r0
            java.lang.ref.WeakReference r1 = r0.f14599a
            java.lang.Object r1 = r1.get()
            w2.f r1 = (w2.f) r1
            if (r1 == 0) goto La9
            y1.s r0 = r0.f14601c
            int r0 = r0.b()
            w2.g r2 = r1.f13850a
            monitor-enter(r2)
            int r1 = r2.f13869n     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L24
            boolean r3 = r2.f13862e     // Catch: java.lang.Throwable -> L21
            if (r3 != 0) goto L24
            monitor-exit(r2)
            return
        L21:
            r0 = move-exception
            goto La7
        L24:
            if (r1 != r0) goto L2c
            java.lang.String r1 = r2.f13870o     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L2c
            monitor-exit(r2)
            return
        L2c:
            r2.f13869n = r0     // Catch: java.lang.Throwable -> L21
            r1 = 1
            if (r0 == r1) goto La5
            if (r0 == 0) goto La5
            r1 = 8
            if (r0 != r1) goto L38
            goto La5
        L38:
            java.lang.String r1 = r2.f13870o     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto L69
            android.content.Context r1 = r2.f13858a     // Catch: java.lang.Throwable -> L21
            int r3 = y1.a0.f14551a     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L5b
            java.lang.String r3 = "phone"
            java.lang.Object r1 = r1.getSystemService(r3)     // Catch: java.lang.Throwable -> L21
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L5b
            java.lang.String r1 = r1.getNetworkCountryIso()     // Catch: java.lang.Throwable -> L21
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L21
            if (r3 != 0) goto L5b
            java.lang.String r1 = android.support.v4.media.session.b.P(r1)     // Catch: java.lang.Throwable -> L21
            goto L67
        L5b:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = r1.getCountry()     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = android.support.v4.media.session.b.P(r1)     // Catch: java.lang.Throwable -> L21
        L67:
            r2.f13870o = r1     // Catch: java.lang.Throwable -> L21
        L69:
            long r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L21
            r2.f13867l = r0     // Catch: java.lang.Throwable -> L21
            y1.v r0 = r2.f13861d     // Catch: java.lang.Throwable -> L21
            r0.getClass()     // Catch: java.lang.Throwable -> L21
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L21
            int r3 = r2.f13863g     // Catch: java.lang.Throwable -> L21
            r8 = 0
            if (r3 <= 0) goto L83
            long r3 = r2.f13864h     // Catch: java.lang.Throwable -> L21
            long r3 = r0 - r3
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L21
            goto L84
        L83:
            r3 = r8
        L84:
            long r4 = r2.i     // Catch: java.lang.Throwable -> L21
            long r6 = r2.f13867l     // Catch: java.lang.Throwable -> L21
            r2.b(r3, r4, r6)     // Catch: java.lang.Throwable -> L21
            r2.f13864h = r0     // Catch: java.lang.Throwable -> L21
            r0 = 0
            r2.i = r0     // Catch: java.lang.Throwable -> L21
            r2.f13866k = r0     // Catch: java.lang.Throwable -> L21
            r2.f13865j = r0     // Catch: java.lang.Throwable -> L21
            w2.t r0 = r2.f     // Catch: java.lang.Throwable -> L21
            java.util.ArrayList r1 = r0.f13897a     // Catch: java.lang.Throwable -> L21
            r1.clear()     // Catch: java.lang.Throwable -> L21
            r1 = -1
            r0.f13899c = r1     // Catch: java.lang.Throwable -> L21
            r0.f13900d = r8     // Catch: java.lang.Throwable -> L21
            r0.f13901e = r8     // Catch: java.lang.Throwable -> L21
            monitor-exit(r2)
            return
        La5:
            monitor-exit(r2)
            return
        La7:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L21
            throw r0
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.c.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map mapA = null;
        int i = 1;
        switch (this.f10053v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f10054w).s(true);
                return;
            case 1:
                l lVar = (l) this.f10054w;
                boolean zIsPopupShowing = lVar.f10073h.isPopupShowing();
                lVar.s(zIsPopupShowing);
                lVar.f10077m = zIsPopupShowing;
                return;
            case 2:
                ((TextInputLayout) this.f10054w).f2992z.requestLayout();
                return;
            case 3:
                com.bumptech.glide.l lVar2 = (com.bumptech.glide.l) this.f10054w;
                ((AtomicReference) lVar2.f2224x).set(null);
                synchronized (lVar2) {
                    try {
                        if (((AtomicMarkableReference) lVar2.f2223w).isMarked()) {
                            mapA = ((pb.d) ((AtomicMarkableReference) lVar2.f2223w).getReference()).a();
                            AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) lVar2.f2223w;
                            atomicMarkableReference.set((pb.d) atomicMarkableReference.getReference(), false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (mapA != null) {
                    tb.c cVar = (tb.c) lVar2.f2225y;
                    ((pb.g) cVar.f11984w).h((String) cVar.f11983v, mapA, lVar2.f2222v);
                    return;
                }
                return;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                LandscapeActivity landscapeActivity = (LandscapeActivity) this.f10054w;
                int i10 = LandscapeActivity.f1490a0;
                landscapeActivity.getClass();
                j4.t(landscapeActivity);
                return;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                MainActivity.w(((r5.j) this.f10054w).f10870a, "");
                return;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                SplashActivity splashActivity = (SplashActivity) this.f10054w;
                splashActivity.Z++;
                splashActivity.f1542a0 = false;
                ((LinearLayout) splashActivity.X.f2035b).setVisibility(0);
                return;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                SupportActivity supportActivity = (SupportActivity) this.f10054w;
                int i11 = SupportActivity.f1548b0;
                supportActivity.x();
                return;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                MaterialButton.a((MaterialButton) this.f10054w);
                return;
            case 9:
                ((CarouselLayoutManager) this.f10054w).p0();
                return;
            case 10:
                v5.m mVar = (v5.m) this.f10054w;
                b6.i iVar = (b6.i) ab.b.s((w4.t) AppDatabase.r(mVar.getContext()).q().f1800w, true, false, new b6.a(3));
                if (iVar == null) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new nc.i(9, mVar, iVar));
                return;
            case 11:
                w0.e eVar = ((w0.g) this.f10054w).f13773a;
                ViewParent parent = eVar.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(eVar);
                    return;
                }
                return;
            case 12:
                x5.l lVar3 = (x5.l) this.f10054w;
                new Handler(Looper.getMainLooper()).post(new nc.i(13, lVar3, (List) ab.b.s((w4.t) AppDatabase.r(lVar3.K()).q().f1800w, true, false, new b6.a(i))));
                return;
            case 13:
                a();
                return;
            case 14:
                ((y2.c) this.f10054w).f14641g.l();
                return;
            case 15:
                ((y2.q) this.f10054w).f14716k--;
                return;
            default:
                z2.k kVar = (z2.k) this.f10054w;
                Surface surface = kVar.C;
                if (surface != null) {
                    Iterator it = kVar.f15161v.iterator();
                    while (it.hasNext()) {
                        ((d0) it.next()).f4651v.J1(null);
                    }
                }
                SurfaceTexture surfaceTexture = kVar.B;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                }
                if (surface != null) {
                    surface.release();
                }
                kVar.B = null;
                kVar.C = null;
                return;
        }
    }
}
