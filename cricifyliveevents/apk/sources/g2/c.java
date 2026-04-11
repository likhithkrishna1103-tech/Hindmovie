package g2;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements ta.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4635v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Context f4636w;

    public /* synthetic */ c(Context context, int i) {
        this.f4635v = i;
        this.f4636w = context;
    }

    @Override // ta.l
    public final Object get() {
        w2.g gVar;
        switch (this.f4635v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return w1.d.g(this.f4636w);
            case 1:
                return new l(this.f4636w);
            case 2:
                return new s2.p(new l4.c0(this.f4636w), new a3.n());
            case 3:
                return new v2.o(this.f4636w, new f9.c0(26));
            default:
                Context context = this.f4636w;
                ua.z0 z0Var = w2.g.f13851p;
                synchronized (w2.g.class) {
                    try {
                        if (w2.g.f13857v == null) {
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
                            w2.g.f13857v = new w2.g(applicationContext, map, true);
                        }
                        gVar = w2.g.f13857v;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return gVar;
        }
    }
}
