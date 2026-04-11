package h2;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import java.util.HashMap;
import java.util.concurrent.Executor;
import s2.c0;
import v1.c1;
import v1.e1;
import v1.f1;
import v1.p;
import v1.p0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public int A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5512a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f5514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlaybackSession f5515d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PlaybackMetrics.Builder f5520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5521l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p0 f5524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f3.a f5525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f3.a f5526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f3.a f5527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public p f5528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public p f5529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public p f5530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5532w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f5533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5534y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f5535z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f5513b = y1.b.i();
    public final e1 f = new e1();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1 f5517g = new c1();
    public final HashMap i = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f5518h = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5516e = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5522m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5523n = 0;

    public k(Context context, PlaybackSession playbackSession) {
        this.f5512a = context.getApplicationContext();
        this.f5515d = playbackSession;
        h hVar = new h();
        this.f5514c = hVar;
        hVar.f5509d = this;
    }

    public final boolean a(f3.a aVar) {
        String str;
        if (aVar == null) {
            return false;
        }
        String str2 = (String) aVar.f3937y;
        h hVar = this.f5514c;
        synchronized (hVar) {
            str = hVar.f;
        }
        return str2.equals(str);
    }

    public final void b() {
        PlaybackMetrics.Builder builder = this.f5520k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.f5520k.setVideoFramesDropped(this.f5534y);
            this.f5520k.setVideoFramesPlayed(this.f5535z);
            Long l10 = (Long) this.f5518h.get(this.f5519j);
            this.f5520k.setNetworkTransferDurationMillis(l10 == null ? 0L : l10.longValue());
            Long l11 = (Long) this.i.get(this.f5519j);
            this.f5520k.setNetworkBytesRead(l11 == null ? 0L : l11.longValue());
            this.f5520k.setStreamSource((l11 == null || l11.longValue() <= 0) ? 0 : 1);
            this.f5513b.execute(new androidx.fragment.app.d(10, this, this.f5520k.build()));
        }
        this.f5520k = null;
        this.f5519j = null;
        this.A = 0;
        this.f5534y = 0;
        this.f5535z = 0;
        this.f5528s = null;
        this.f5529t = null;
        this.f5530u = null;
        this.B = false;
    }

    public final void c(f1 f1Var, c0 c0Var) {
        int iB;
        PlaybackMetrics.Builder builder = this.f5520k;
        if (c0Var == null || (iB = f1Var.b(c0Var.f11156a)) == -1) {
            return;
        }
        c1 c1Var = this.f5517g;
        int i = 0;
        f1Var.f(iB, c1Var, false);
        int i10 = c1Var.f12618c;
        e1 e1Var = this.f;
        f1Var.n(i10, e1Var);
        v1.c0 c0Var2 = e1Var.f12645c.f12697b;
        if (c0Var2 != null) {
            int iG = a0.G(c0Var2.f12605a, c0Var2.f12606b);
            i = iG != 0 ? iG != 1 ? iG != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i);
        if (e1Var.f12653m != -9223372036854775807L && !e1Var.f12651k && !e1Var.i && !e1Var.a()) {
            builder.setMediaDurationMillis(a0.b0(e1Var.f12653m));
        }
        builder.setPlaybackType(e1Var.a() ? 2 : 1);
        this.B = true;
    }

    public final void d(a aVar, String str) {
        c0 c0Var = aVar.f5483d;
        if ((c0Var == null || !c0Var.b()) && str.equals(this.f5519j)) {
            b();
        }
        this.f5518h.remove(str);
        this.i.remove(str);
    }

    public final void e(int i, long j4, p pVar, int i10) {
        int i11;
        TrackChangeEvent.Builder timeSinceCreatedMillis = i.l(i).setTimeSinceCreatedMillis(j4 - this.f5516e);
        if (pVar != null) {
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
            String str = pVar.f12945m;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = pVar.f12946n;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = pVar.f12943k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i12 = pVar.f12942j;
            if (i12 != -1) {
                timeSinceCreatedMillis.setBitrate(i12);
            }
            int i13 = pVar.f12953u;
            if (i13 != -1) {
                timeSinceCreatedMillis.setWidth(i13);
            }
            int i14 = pVar.f12954v;
            if (i14 != -1) {
                timeSinceCreatedMillis.setHeight(i14);
            }
            int i15 = pVar.F;
            if (i15 != -1) {
                timeSinceCreatedMillis.setChannelCount(i15);
            }
            int i16 = pVar.G;
            if (i16 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i16);
            }
            String str4 = pVar.f12938d;
            if (str4 != null) {
                int i17 = a0.f14551a;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = pVar.f12957y;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        this.f5513b.execute(new androidx.fragment.app.d(7, this, timeSinceCreatedMillis.build()));
    }
}
