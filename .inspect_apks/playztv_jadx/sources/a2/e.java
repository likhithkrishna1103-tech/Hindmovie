package a2;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements z9.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f189u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Context f190v;

    public /* synthetic */ e(Context context, int i) {
        this.f189u = i;
        this.f190v = context;
    }

    @Override // z9.l
    public final Object get() {
        s2.g gVar;
        switch (this.f189u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return q1.c.C(this.f190v);
            case 1:
                return new n(this.f190v);
            case 2:
                return new o2.q(new pb.c(this.f190v, 15), new w2.m());
            case 3:
                return new r2.p(this.f190v, new k8.z(23));
            default:
                Context context = this.f190v;
                aa.c1 c1Var = s2.g.f11738p;
                synchronized (s2.g.class) {
                    try {
                        if (s2.g.f11744v == null) {
                            Context applicationContext = context == null ? null : context.getApplicationContext();
                            HashMap map = new HashMap(8);
                            map.put(0, 1000000L);
                            map.put(2, -9223372036854775807L);
                            map.put(3, -9223372036854775807L);
                            map.put(4, -9223372036854775807L);
                            map.put(5, -9223372036854775807L);
                            map.put(10, -9223372036854775807L);
                            map.put(9, -9223372036854775807L);
                            map.put(7, -9223372036854775807L);
                            s2.g.f11744v = new s2.g(applicationContext, map, true);
                        }
                        gVar = s2.g.f11744v;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return gVar;
        }
    }
}
