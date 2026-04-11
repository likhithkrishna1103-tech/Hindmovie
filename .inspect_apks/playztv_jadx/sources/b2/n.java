package b2;

import a2.g0;
import aa.l0;
import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import java.util.HashMap;
import java.util.concurrent.Executor;
import o2.d0;
import p1.c0;
import p1.c1;
import p1.e1;
import p1.f1;
import p1.p0;
import p1.q;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public int A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1763a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f1765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlaybackSession f1766d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PlaybackMetrics.Builder f1771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1772l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p0 f1775o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l0 f1776p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l0 f1777q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public l0 f1778r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public q f1779s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q f1780t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q f1781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1782v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1783w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1784x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1785y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1786z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1764b = s1.b.i();
    public final e1 f = new e1();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1 f1768g = new c1();
    public final HashMap i = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f1769h = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1767e = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1773m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1774n = 0;

    public n(Context context, PlaybackSession playbackSession) {
        this.f1763a = context.getApplicationContext();
        this.f1766d = playbackSession;
        j jVar = new j();
        this.f1765c = jVar;
        jVar.f1758d = this;
    }

    public final boolean a(l0 l0Var) {
        String str;
        if (l0Var == null) {
            return false;
        }
        String str2 = (String) l0Var.f707x;
        j jVar = this.f1765c;
        synchronized (jVar) {
            str = jVar.f;
        }
        return str2.equals(str);
    }

    public final void b() {
        PlaybackMetrics.Builder builder = this.f1771k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.f1771k.setVideoFramesDropped(this.f1785y);
            this.f1771k.setVideoFramesPlayed(this.f1786z);
            Long l10 = (Long) this.f1769h.get(this.f1770j);
            this.f1771k.setNetworkTransferDurationMillis(l10 == null ? 0L : l10.longValue());
            Long l11 = (Long) this.i.get(this.f1770j);
            this.f1771k.setNetworkBytesRead(l11 == null ? 0L : l11.longValue());
            this.f1771k.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            this.f1764b.execute(new g0(this, 5, this.f1771k.build()));
        }
        this.f1771k = null;
        this.f1770j = null;
        this.A = 0;
        this.f1785y = 0;
        this.f1786z = 0;
        this.f1779s = null;
        this.f1780t = null;
        this.f1781u = null;
        this.B = false;
    }

    public final void c(f1 f1Var, d0 d0Var) {
        int iB;
        PlaybackMetrics.Builder builder = this.f1771k;
        if (d0Var == null || (iB = f1Var.b(d0Var.f9090a)) == -1) {
            return;
        }
        c1 c1Var = this.f1768g;
        int i = 0;
        f1Var.f(iB, c1Var, false);
        int i10 = c1Var.f9678c;
        e1 e1Var = this.f;
        f1Var.n(i10, e1Var);
        c0 c0Var = e1Var.f9715c.f9757b;
        if (c0Var != null) {
            int iG = b0.G(c0Var.f9665a, c0Var.f9666b);
            i = iG != 0 ? iG != 1 ? iG != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        if (e1Var.f9723m != -9223372036854775807L && !e1Var.f9721k && !e1Var.i && !e1Var.a()) {
            builder.setMediaDurationMillis(b0.b0(e1Var.f9723m));
        }
        builder.setPlaybackType(e1Var.a() ? 2 : 1);
        this.B = true;
    }

    public final void d(a aVar, String str) {
        d0 d0Var = aVar.f1722d;
        if ((d0Var == null || !d0Var.b()) && str.equals(this.f1770j)) {
            b();
        }
        this.f1769h.remove(str);
        this.i.remove(str);
    }

    public final void e(int i, long j5, q qVar, int i10) {
        int i11;
        TrackChangeEvent.Builder timeSinceCreatedMillis = k.l(i).setTimeSinceCreatedMillis(j5 - this.f1767e);
        int i12 = 2;
        if (qVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i10 != 1) {
                i11 = 3;
                if (i10 != 2) {
                    i11 = i10 != 3 ? 1 : 4;
                }
            } else {
                i11 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i11);
            String str = qVar.f10022m;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = qVar.f10023n;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = qVar.f10020k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = qVar.f10019j;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = qVar.f10030u;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = qVar.f10031v;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = qVar.F;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = qVar.G;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = qVar.f10015d;
            if (str4 != null) {
                int i18 = b0.f11647a;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = qVar.f10034y;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        this.f1764b.execute(new g0(this, i12, timeSinceCreatedMillis.build()));
    }
}
