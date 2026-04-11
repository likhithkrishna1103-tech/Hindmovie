package ib;

import androidx.media3.decoder.DecoderInputBuffer;
import gb.g;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements hb.a {
    public static final b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f6476g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f6478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f6480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f6475e = new a(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f6477h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [ib.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [ib.b] */
    static {
        final int i = 0;
        f = new gb.f() { // from class: ib.b
            @Override // gb.a
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
        f6476g = new gb.f() { // from class: ib.b
            @Override // gb.a
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
        this.f6478a = map;
        HashMap map2 = new HashMap();
        this.f6479b = map2;
        this.f6480c = f6475e;
        this.f6481d = false;
        map2.put(String.class, f);
        map.remove(String.class);
        map2.put(Boolean.class, f6476g);
        map.remove(Boolean.class);
        map2.put(Date.class, f6477h);
        map.remove(Date.class);
    }

    public final hb.a a(Class cls, gb.d dVar) {
        this.f6478a.put(cls, dVar);
        this.f6479b.remove(cls);
        return this;
    }
}
