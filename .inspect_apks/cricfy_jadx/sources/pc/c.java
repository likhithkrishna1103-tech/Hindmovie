package pc;

import a5.j;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.c0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import b2.x;
import com.google.android.material.navigation.NavigationView;
import d5.f;
import d7.q;
import da.g;
import f9.q4;
import f9.y0;
import f9.z;
import g7.l;
import i2.m;
import j2.h;
import j9.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import k2.u;
import kf.e;
import md.k;
import n.i;
import s2.t;
import u0.o;
import v1.n0;
import w2.n;
import w2.r;
import x3.p;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e.b, e, g, f, y0, i, k, p, l, hf.c, i2.p, o, w2.i, d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile c f10179w;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10180v;

    public /* synthetic */ c(Object obj) {
        this.f10180v = obj;
    }

    public static i8.a J(e5.c cVar) {
        HashMap map = new HashMap(20);
        map.put("_id", new a5.g(1, 1, "_id", "INTEGER", null, true));
        map.put("_namespace", new a5.g(0, 1, "_namespace", "TEXT", null, true));
        map.put("_url", new a5.g(0, 1, "_url", "TEXT", null, true));
        map.put("_file", new a5.g(0, 1, "_file", "TEXT", null, true));
        map.put("_group", new a5.g(0, 1, "_group", "INTEGER", null, true));
        map.put("_priority", new a5.g(0, 1, "_priority", "INTEGER", null, true));
        map.put("_headers", new a5.g(0, 1, "_headers", "TEXT", null, true));
        map.put("_written_bytes", new a5.g(0, 1, "_written_bytes", "INTEGER", null, true));
        map.put("_total_bytes", new a5.g(0, 1, "_total_bytes", "INTEGER", null, true));
        map.put("_status", new a5.g(0, 1, "_status", "INTEGER", null, true));
        map.put("_error", new a5.g(0, 1, "_error", "INTEGER", null, true));
        map.put("_network_type", new a5.g(0, 1, "_network_type", "INTEGER", null, true));
        map.put("_created", new a5.g(0, 1, "_created", "INTEGER", null, true));
        map.put("_tag", new a5.g(0, 1, "_tag", "TEXT", null, false));
        map.put("_enqueue_action", new a5.g(0, 1, "_enqueue_action", "INTEGER", null, true));
        map.put("_identifier", new a5.g(0, 1, "_identifier", "INTEGER", null, true));
        map.put("_download_on_enqueue", new a5.g(0, 1, "_download_on_enqueue", "INTEGER", null, true));
        map.put("_extras", new a5.g(0, 1, "_extras", "TEXT", null, true));
        map.put("_auto_retry_max_attempts", new a5.g(0, 1, "_auto_retry_max_attempts", "INTEGER", null, true));
        map.put("_auto_retry_attempts", new a5.g(0, 1, "_auto_retry_attempts", "INTEGER", null, true));
        HashSet hashSet = new HashSet(0);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new a5.i("index_requests__file", true, Arrays.asList("_file"), Arrays.asList("ASC")));
        hashSet2.add(new a5.i("index_requests__group__status", false, Arrays.asList("_group", "_status"), Arrays.asList("ASC", "ASC")));
        j jVar = new j("requests", map, hashSet, hashSet2);
        j jVarM = com.bumptech.glide.e.m(new f5.a(cVar), "requests");
        if (jVar.equals(jVarM)) {
            return new i8.a(true, (String) null, 3);
        }
        return new i8.a(false, "requests(com.tonyodev.fetch2.database.DownloadInfo).\n Expected:\n" + jVar + "\n Found:\n" + jVarM, 3);
    }

    @Override // j9.d
    public void A(j9.p pVar) {
        ((CountDownLatch) this.f10180v).countDown();
    }

    @Override // w2.i
    public void B(w2.k kVar, long j4, long j7, int i) {
        t tVar;
        r rVar = (r) kVar;
        h hVar = (h) this.f10180v;
        if (i == 0) {
            long j10 = rVar.f13887v;
            tVar = new t(rVar.f13888w);
        } else {
            long j11 = rVar.f13887v;
            Uri uri = rVar.f13890y.f1686x;
            tVar = new t(j7);
        }
        hVar.f6547q.s(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    @Override // x3.p
    public void C(byte[] bArr, int i, int i10, x3.o oVar, y1.h hVar) {
        x1.b bVarA;
        y1.t tVar = (y1.t) this.f10180v;
        tVar.H(i + i10, bArr);
        tVar.J(i);
        ArrayList arrayList = new ArrayList();
        while (tVar.a() > 0) {
            y1.d.a("Incomplete Mp4Webvtt Top Level box header found.", tVar.a() >= 8);
            int iJ = tVar.j();
            if (tVar.j() == 1987343459) {
                int i11 = iJ - 8;
                CharSequence charSequenceF = null;
                x1.a aVarA = null;
                while (i11 > 0) {
                    y1.d.a("Incomplete vtt cue box header found.", i11 >= 8);
                    int iJ2 = tVar.j();
                    int iJ3 = tVar.j();
                    int i12 = iJ2 - 8;
                    byte[] bArr2 = tVar.f14609a;
                    int i13 = tVar.f14610b;
                    int i14 = a0.f14551a;
                    String str = new String(bArr2, i13, i12, StandardCharsets.UTF_8);
                    tVar.K(i12);
                    i11 = (i11 - 8) - i12;
                    if (iJ3 == 1937011815) {
                        g4.h hVar2 = new g4.h();
                        g4.i.e(str, hVar2);
                        aVarA = hVar2.a();
                    } else if (iJ3 == 1885436268) {
                        charSequenceF = g4.i.f(null, str.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (charSequenceF == null) {
                    charSequenceF = "";
                }
                if (aVarA != null) {
                    aVarA.f14225a = charSequenceF;
                    aVarA.f14226b = null;
                    bVarA = aVarA.a();
                } else {
                    Pattern pattern = g4.i.f5020a;
                    g4.h hVar3 = new g4.h();
                    hVar3.f5013c = charSequenceF;
                    bVarA = hVar3.a().a();
                }
                arrayList.add(bVarA);
            } else {
                tVar.K(iJ - 8);
            }
        }
        hVar.accept(new x3.c(-9223372036854775807L, -9223372036854775807L, arrayList));
    }

    @Override // x3.p
    public int D() {
        return 2;
    }

    @Override // md.k
    public boolean E() {
        return ((fd.d) this.f10180v).A;
    }

    @Override // i2.p
    public void G(int i, long j4, long j7) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, i, j4, j7));
        }
    }

    public Set H() {
        Set setUnmodifiableSet;
        synchronized (((HashSet) this.f10180v)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) this.f10180v);
        }
        return setUnmodifiableSet;
    }

    public void I() {
        ((c0) this.f10180v).f954z.Q();
    }

    @Override // d5.f
    public void a(d5.e eVar) {
        f5.e eVar2 = (f5.e) this.f10180v;
        int length = eVar2.f3970y.length;
        for (int i = 1; i < length; i++) {
            int i10 = eVar2.f3970y[i];
            if (i10 == 1) {
                eVar.e(i, eVar2.f3971z[i]);
            } else if (i10 == 2) {
                eVar.t(i, eVar2.A[i]);
            } else if (i10 == 3) {
                String str = eVar2.B[i];
                ge.i.b(str);
                eVar.n(i, str);
            } else if (i10 == 4) {
                byte[] bArr = eVar2.C[i];
                ge.i.b(bArr);
                eVar.S(i, bArr);
            } else if (i10 == 5) {
                eVar.b(i);
            }
        }
    }

    @Override // i2.p
    public void b(boolean z10) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.j(kVar, z10));
        }
    }

    @Override // u0.o
    public boolean c(View view) {
        DrawerLayout drawerLayout = (DrawerLayout) this.f10180v;
        if (!DrawerLayout.n(view) || drawerLayout.i(view) == 2) {
            return false;
        }
        drawerLayout.c(view, true);
        return true;
    }

    @Override // i2.p
    public void d(int i) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new d6.i(i, 2, kVar));
        }
    }

    @Override // i2.p
    public void e(m mVar) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, mVar, 9));
        }
    }

    @Override // i2.p
    public void f(long j4) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, j4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.i
    public i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        long jMin;
        r rVar = (r) kVar;
        h hVar = (h) this.f10180v;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        t tVar = new t(j7);
        int i10 = rVar.f13889x;
        hVar.f6543m.getClass();
        if ((iOException instanceof n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof x) || (iOException instanceof n)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = b2.l.f1700w;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof b2.l) && ((b2.l) cause).f1701v == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        i4.e eVar = jMin == -9223372036854775807L ? w2.o.f : new i4.e(0, jMin, 0 == true ? 1 : 0);
        hVar.f6547q.q(tVar, i10, iOException, !eVar.a());
        return eVar;
    }

    @Override // i2.p
    public void h() {
        v2.o oVar;
        androidx.media3.decoder.ffmpeg.c cVar = (androidx.media3.decoder.ffmpeg.c) this.f10180v;
        synchronized (cVar.f4657v) {
            oVar = cVar.M;
        }
        if (oVar != null) {
            oVar.h();
        }
    }

    @Override // e.b
    public void i(Object obj) {
        e.a aVar = (e.a) obj;
        r0 r0Var = (r0) this.f10180v;
        androidx.fragment.app.n0 n0Var = (androidx.fragment.app.n0) r0Var.D.pollFirst();
        if (n0Var == null) {
            Log.w("FragmentManager", "No IntentSenders were started for " + this);
            return;
        }
        String str = n0Var.f1024v;
        int i = n0Var.f1025w;
        y yVarK = r0Var.f1046c.k(str);
        if (yVarK != null) {
            yVarK.t(i, aVar.f3733v, aVar.f3734w);
            return;
        }
        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
    }

    @Override // kf.e
    public void j(IOException iOException) {
        ((ya.c0) this.f10180v).l(iOException);
    }

    @Override // w2.i
    public void k(w2.k kVar, long j4, long j7) {
        int i;
        boolean z10;
        long j10;
        r rVar = (r) kVar;
        h hVar = (h) this.f10180v;
        long j11 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        t tVar = new t(j7);
        hVar.f6543m.getClass();
        hVar.f6547q.o(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        k2.c cVar = (k2.c) rVar.A;
        k2.c cVar2 = hVar.H;
        int size = cVar2 == null ? 0 : cVar2.f6841m.size();
        long j12 = cVar.b(0).f6860b;
        int i10 = 0;
        while (i10 < size && hVar.H.b(i10).f6860b < j12) {
            i10++;
        }
        if (cVar.f6834d) {
            if (size - i10 > cVar.f6841m.size()) {
                y1.b.p("DashMediaSource", "Loaded out of sync manifest");
            } else {
                j10 = -9223372036854775807L;
                long j13 = hVar.N;
                if (j13 != -9223372036854775807L) {
                    i = i10;
                    z10 = true;
                    if (cVar.f6837h * 1000 <= j13) {
                        y1.b.p("DashMediaSource", "Loaded stale dynamic manifest: " + cVar.f6837h + ", " + hVar.N);
                    }
                } else {
                    i = i10;
                    z10 = true;
                }
                hVar.M = 0;
            }
            int i11 = hVar.M;
            hVar.M = i11 + 1;
            if (i11 < hVar.f6543m.m(rVar.f13889x)) {
                hVar.D.postDelayed(hVar.f6552v, Math.min((hVar.M - 1) * 1000, 5000));
                return;
            } else {
                hVar.C = new a2.a();
                return;
            }
        }
        i = i10;
        z10 = true;
        j10 = -9223372036854775807L;
        hVar.H = cVar;
        hVar.I = cVar.f6834d & hVar.I;
        hVar.J = j4 - j7;
        hVar.K = j4;
        hVar.O += i;
        synchronized (hVar.f6550t) {
            if (rVar.f13888w.f1714a.equals(hVar.F)) {
                Uri uriV = hVar.H.f6839k;
                if (uriV == null) {
                    uriV = ab.b.v(rVar.f13890y.f1686x);
                }
                hVar.F = uriV;
            }
        }
        k2.c cVar3 = hVar.H;
        if (!cVar3.f6834d || hVar.L != j10) {
            hVar.y(true);
            return;
        }
        u uVar = cVar3.i;
        if (uVar == null) {
            hVar.v();
            return;
        }
        String str = uVar.f6898b;
        if (Objects.equals(str, "urn:mpeg:dash:utc:direct:2014") || Objects.equals(str, "urn:mpeg:dash:utc:direct:2012")) {
            try {
                hVar.L = a0.R(uVar.f6899c) - hVar.K;
                hVar.y(z10);
                return;
            } catch (n0 e9) {
                hVar.x(e9);
                return;
            }
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            hVar.z(uVar, new j2.g());
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            hVar.z(uVar, new z(14));
        } else if (Objects.equals(str, "urn:mpeg:dash:utc:ntp:2014") || Objects.equals(str, "urn:mpeg:dash:utc:ntp:2012")) {
            hVar.v();
        } else {
            hVar.x(new IOException("Unsupported UTC timing scheme"));
        }
    }

    @Override // f9.y0
    public /* synthetic */ void l(String str, int i, Throwable th, byte[] bArr, Map map) {
        ((q4) this.f10180v).v(str, i, th, bArr, map);
    }

    @Override // kf.e
    public void m(kf.z zVar) {
        ((ya.c0) this.f10180v).k(zVar);
    }

    @Override // w2.i
    public void n(w2.k kVar, long j4, long j7, boolean z10) {
        ((h) this.f10180v).w((r) kVar, j7);
    }

    @Override // g7.l
    public short o() throws IOException {
        int i = ((InputStream) this.f10180v).read();
        if (i != -1) {
            return (short) i;
        }
        throw new g7.k();
    }

    @Override // i2.p
    public void p() {
        ((androidx.media3.decoder.ffmpeg.c) this.f10180v).f1257k0 = true;
    }

    @Override // i2.p
    public void q(Exception exc) {
        y1.b.h("DecoderAudioRenderer", "Audio sink error", exc);
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, exc, 5));
        }
    }

    @Override // x3.p
    public /* synthetic */ x3.g r(byte[] bArr, int i, int i10) {
        return l0.e.a(this, bArr, i10);
    }

    @Override // d5.f
    public String s() {
        return ((f5.e) this.f10180v).f3973w;
    }

    @Override // g7.l
    public long skip(long j4) throws IOException {
        InputStream inputStream = (InputStream) this.f10180v;
        if (j4 < 0) {
            return 0L;
        }
        long j7 = j4;
        while (j7 > 0) {
            long jSkip = inputStream.skip(j7);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j7 -= jSkip;
        }
        return j4 - j7;
    }

    @Override // i2.p
    public void t() {
        ((androidx.media3.decoder.ffmpeg.c) this.f10180v).f1251e0 = true;
    }

    @Override // g7.l
    public int v() {
        return (o() << 8) | o();
    }

    @Override // i2.p
    public void w(m mVar) {
        i2.k kVar = ((androidx.media3.decoder.ffmpeg.c) this.f10180v).N;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, mVar, 1));
        }
    }

    @Override // n.i
    public boolean x(n.k kVar, MenuItem menuItem) {
        fa.f fVar = ((NavigationView) this.f10180v).E;
        if (fVar == null) {
            return false;
        }
        fVar.c(menuItem);
        return true;
    }

    @Override // g7.l
    public int z(int i, byte[] bArr) throws g7.k {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i && (i11 = ((InputStream) this.f10180v).read(bArr, i10, i - i10)) != -1) {
            i10 += i11;
        }
        if (i10 == 0 && i11 == -1) {
            throw new g7.k();
        }
        return i10;
    }

    public c(int i) {
        switch (i) {
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f10180v = new AtomicInteger(0);
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                this.f10180v = new q(500L);
                break;
            case 17:
                this.f10180v = new y1.t();
                break;
            case 25:
                this.f10180v = new c(26);
                break;
            case 26:
                this.f10180v = new j9.p();
                break;
            default:
                this.f10180v = new HashSet();
                break;
        }
    }

    @Override // i2.p
    public /* synthetic */ void F() {
    }

    @Override // x3.p
    public /* synthetic */ void reset() {
    }

    @Override // i2.p
    public /* synthetic */ void u() {
    }

    @Override // n.i
    public void y(n.k kVar) {
    }
}
