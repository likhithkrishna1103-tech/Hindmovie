package f9;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.i7;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.k9;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.s8;
import com.google.android.gms.internal.measurement.x7;
import com.google.android.gms.internal.measurement.y8;
import com.google.android.material.tabs.TabLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class z implements w, g7.o, g7.f0, w2.q, x6.k, j9.h, t4.b, t7.c, v3.g, w8.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4506v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ z f4502w = new z(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ z f4503x = new z(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ z f4504y = new z(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ z f4505z = new z(3);
    public static final /* synthetic */ z A = new z(4);
    public static final /* synthetic */ z B = new z(5);
    public static final /* synthetic */ z C = new z(6);
    public static final /* synthetic */ z D = new z(7);
    public static final /* synthetic */ z E = new z(8);
    public static final /* synthetic */ z F = new z(9);
    public static final /* synthetic */ z G = new z(10);

    public /* synthetic */ z(int i) {
        this.f4506v = i;
    }

    public static RectF i(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.f2942c0 || !(view instanceof oa.k)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        oa.k kVar = (oa.k) view;
        int contentWidth = kVar.getContentWidth();
        int contentHeight = kVar.getContentHeight();
        int iA = (int) da.e0.a(kVar.getContext(), 24);
        if (contentWidth < iA) {
            contentWidth = iA;
        }
        int right = (kVar.getRight() + kVar.getLeft()) / 2;
        int bottom = (kVar.getBottom() + kVar.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    public static p6.a k(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new p6.a(httpURLConnection);
    }

    public static Path q(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(f, f10);
        path.lineTo(f11, f12);
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean r(m1.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.z.r(m1.b, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        return vf.g.A(Boolean.TRUE);
    }

    @Override // f9.w
    public Object a() {
        switch (this.f4506v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                List list = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.D.b();
            case 1:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2434r0.b()).longValue());
            case 2:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2443w.b()).longValue());
            case 3:
                List list4 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.B.b()).longValue());
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                List list5 = f0.f4108a;
                Boolean bool = (Boolean) x7.f2728c.b();
                bool.getClass();
                return bool;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                List list6 = f0.f4108a;
                return Integer.valueOf((int) ((Long) i7.f2489a.b()).longValue());
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                List list7 = f0.f4108a;
                Boolean bool2 = (Boolean) k9.f2513a.b();
                bool2.getClass();
                return bool2;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                List list8 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool3 = (Boolean) s8.f2628h.b();
                bool3.getClass();
                return bool3;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                List list9 = f0.f4108a;
                Boolean bool4 = (Boolean) o7.f2563b.b();
                bool4.getClass();
                return bool4;
            case 9:
                List list10 = f0.f4108a;
                Boolean bool5 = (Boolean) y8.f2739a.b();
                bool5.getClass();
                return bool5;
            default:
                return new Boolean(((Boolean) j8.f2500a.b()).booleanValue());
        }
    }

    @Override // v3.g
    public a3.c0 b() {
        return new a3.u(-9223372036854775807L);
    }

    @Override // v3.g
    public long c(a3.q qVar) {
        return -1L;
    }

    @Override // w2.q
    public Object g(Uri uri, b2.m mVar) {
        return Long.valueOf(y1.a0.R(new BufferedReader(new InputStreamReader(mVar)).readLine()));
    }

    @Override // x6.k
    public int l(x6.h hVar) {
        return 1;
    }

    @Override // x6.b
    public boolean m(Object obj, File file, x6.h hVar) throws Throwable {
        try {
            s7.b.d(((k7.g) ((k7.b) ((z6.b0) obj).get()).f7212v.f1841b).f7225a.f13481d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e9) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e9);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r4
      0x001b: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // w8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a3.d n(android.content.Context r3, java.lang.String r4, w8.b r5) {
        /*
            r2 = this;
            a3.d r0 = new a3.d
            r0.<init>()
            int r1 = r5.g(r3, r4)
            r0.f154a = r1
            r1 = 1
            int r3 = r5.e(r3, r4, r1)
            r0.f155b = r3
            int r4 = r0.f154a
            if (r4 != 0) goto L1b
            r4 = 0
            if (r3 != 0) goto L1b
            r1 = r4
            goto L1e
        L1b:
            if (r4 < r3) goto L1e
            r1 = -1
        L1e:
            r0.f156c = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.z.n(android.content.Context, java.lang.String, w8.b):a3.d");
    }

    @Override // g7.f0
    public void p(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
    }

    public void s(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF rectFI = i(tabLayout, view);
        RectF rectFI2 = i(tabLayout, view2);
        drawable.setBounds(l9.a.c(f, (int) rectFI.left, (int) rectFI2.left), drawable.getBounds().top, l9.a.c(f, (int) rectFI.right, (int) rectFI2.right), drawable.getBounds().bottom);
    }

    @Override // g7.f0
    public void v(MediaExtractor mediaExtractor, Object obj) throws IOException {
        mediaExtractor.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
    }

    @Override // t4.b
    public void h() {
    }

    @Override // g7.o
    public void o() {
    }

    @Override // v3.g
    public void d(long j4) {
    }

    @Override // t7.c
    public void f(Object obj) {
    }

    @Override // g7.o
    public void e(a7.b bVar, Bitmap bitmap) {
    }

    @Override // t4.b
    public void j(int i, Object obj) {
    }
}
