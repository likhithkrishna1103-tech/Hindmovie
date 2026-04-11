package cc;

import ac.g;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements bc.a {
    public static final b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f2131g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2130e = new a(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f2132h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [cc.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [cc.b] */
    static {
        final int i = 0;
        f = new ac.f() { // from class: cc.b
            @Override // ac.a
            public final void a(Object obj, Object obj2) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        ((g) obj2).e((String) obj);
                        break;
                    default:
                        ((g) obj2).f(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i10 = 1;
        f2131g = new ac.f() { // from class: cc.b
            @Override // ac.a
            public final void a(Object obj, Object obj2) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        ((g) obj2).e((String) obj);
                        break;
                    default:
                        ((g) obj2).f(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap map = new HashMap();
        this.f2133a = map;
        HashMap map2 = new HashMap();
        this.f2134b = map2;
        this.f2135c = f2130e;
        this.f2136d = false;
        map2.put(String.class, f);
        map.remove(String.class);
        map2.put(Boolean.class, f2131g);
        map.remove(Boolean.class);
        map2.put(Date.class, f2132h);
        map.remove(Date.class);
    }

    public final bc.a a(Class cls, ac.d dVar) {
        this.f2133a.put(cls, dVar);
        this.f2134b.remove(cls);
        return this;
    }
}
