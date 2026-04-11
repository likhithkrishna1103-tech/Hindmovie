package a2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.k f332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f333c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f334d;

    public n(Context context) {
        this.f331a = context;
        this.f332b = new c7.k(context);
    }

    public final g[] a(Handler handler, l0 l0Var, l0 l0Var2, l0 l0Var3, l0 l0Var4) {
        int i;
        Integer num;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Constructor<?> constructor;
        Object[] objArr;
        ArrayList arrayList = new ArrayList();
        int i17 = this.f333c;
        boolean z2 = this.f334d;
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Long.TYPE;
        Context context = this.f331a;
        u2.h hVar = new u2.h(context);
        c7.k kVar = this.f332b;
        hVar.f12583c = kVar;
        hVar.f12584d = 5000L;
        hVar.f12585e = z2;
        hVar.f = handler;
        hVar.f12586g = l0Var;
        hVar.f12587h = 50;
        s1.d.g(!hVar.f12582b);
        Handler handler2 = hVar.f;
        s1.d.g((handler2 == null && hVar.f12586g == null) || !(handler2 == null || hVar.f12586g == null));
        hVar.f12582b = true;
        arrayList.add(new u2.j(hVar));
        if (i17 == 0) {
            i = 3;
        } else {
            int size = arrayList.size();
            i = 3;
            if (i17 == 2) {
                size--;
            }
            int i18 = size;
            try {
                try {
                    num = 50;
                    try {
                        i10 = i18 + 1;
                    } catch (ClassNotFoundException unused) {
                    }
                    try {
                        arrayList.add(i18, (g) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, u2.c0.class, cls).newInstance(5000L, handler, l0Var, 50));
                        s1.b.k("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused2) {
                        i18 = i10;
                        i10 = i18;
                    }
                } catch (Exception e10) {
                    throw new IllegalStateException("Error instantiating VP9 extension", e10);
                }
            } catch (ClassNotFoundException unused3) {
                num = 50;
            }
            try {
                try {
                    i11 = i10 + 1;
                    try {
                        arrayList.add(i10, (g) Class.forName("androidx.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, u2.c0.class, cls).newInstance(5000L, handler, l0Var, num));
                        s1.b.k("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                    } catch (ClassNotFoundException unused4) {
                        i10 = i11;
                        i11 = i10;
                    }
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    arrayList.add(i11, (g) androidx.media3.decoder.ffmpeg.a.class.getConstructor(cls2, Handler.class, u2.c0.class, cls).newInstance(5000L, handler, l0Var, num));
                    s1.b.k("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
                } catch (ClassNotFoundException unused6) {
                } catch (Exception e11) {
                    throw new IllegalStateException("Error instantiating FFmpeg extension", e11);
                }
            } catch (Exception e12) {
                throw new IllegalStateException("Error instantiating AV1 extension", e12);
            }
        }
        c2.x xVar = new c2.x(context, 0);
        s1.d.g(!xVar.f2413b);
        xVar.f2413b = true;
        if (((a7.b) xVar.f2415d) == null) {
            xVar.f2415d = new a7.b(new q1.g[0]);
        }
        if (((h4.z) xVar.f2417g) == null) {
            xVar.f2417g = new h4.z(context);
        }
        c2.e0 e0Var = new c2.e0(xVar);
        int i19 = this.f333c;
        boolean z10 = this.f334d;
        Context context2 = this.f331a;
        arrayList.add(new c2.g0(context2, kVar, z10, handler, l0Var2, e0Var));
        if (i19 != 0) {
            int size2 = arrayList.size();
            if (i19 == 2) {
                size2--;
            }
            try {
                try {
                    Class<?> cls3 = Class.forName("androidx.media3.decoder.midi.MidiRenderer");
                    Class<?>[] clsArr = new Class[4];
                    clsArr[0] = Context.class;
                    clsArr[1] = Handler.class;
                    clsArr[2] = c2.j.class;
                    clsArr[i] = c2.q.class;
                    constructor = cls3.getConstructor(clsArr);
                    objArr = new Object[4];
                    objArr[0] = context2;
                    objArr[1] = handler;
                    objArr[2] = l0Var2;
                    objArr[i] = e0Var;
                    i12 = size2 + 1;
                } catch (Exception e13) {
                    throw new IllegalStateException("Error instantiating MIDI extension", e13);
                }
            } catch (ClassNotFoundException unused7) {
            }
            try {
                arrayList.add(size2, (g) constructor.newInstance(objArr));
                s1.b.k("DefaultRenderersFactory", "Loaded MidiRenderer.");
            } catch (ClassNotFoundException unused8) {
                size2 = i12;
                i12 = size2;
            }
            try {
                try {
                    Class<?> cls4 = Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer");
                    int i20 = i;
                    Class<?>[] clsArr2 = new Class[i20];
                    clsArr2[0] = Handler.class;
                    clsArr2[1] = c2.j.class;
                    clsArr2[2] = c2.q.class;
                    Constructor<?> constructor2 = cls4.getConstructor(clsArr2);
                    Object[] objArr2 = new Object[i20];
                    objArr2[0] = handler;
                    objArr2[1] = l0Var2;
                    objArr2[2] = e0Var;
                    i13 = i12 + 1;
                    try {
                        arrayList.add(i12, (g) constructor2.newInstance(objArr2));
                        s1.b.k("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused9) {
                        i12 = i13;
                        i13 = i12;
                    }
                } catch (ClassNotFoundException unused10) {
                }
                try {
                    try {
                        i14 = i13 + 1;
                        try {
                            arrayList.add(i13, (g) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, c2.j.class, c2.q.class).newInstance(handler, l0Var2, e0Var));
                            s1.b.k("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused11) {
                            i13 = i14;
                            i14 = i13;
                        }
                    } catch (ClassNotFoundException unused12) {
                    }
                    try {
                        try {
                            i15 = i14 + 1;
                        } catch (ClassNotFoundException unused13) {
                        }
                        try {
                            arrayList.add(i14, (g) androidx.media3.decoder.ffmpeg.c.class.getConstructor(Handler.class, c2.j.class, c2.q.class).newInstance(handler, l0Var2, e0Var));
                            s1.b.k("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        } catch (ClassNotFoundException unused14) {
                            i14 = i15;
                            i15 = i14;
                        }
                        try {
                            try {
                                Object[] objArr3 = {context2, handler, l0Var2, e0Var};
                                i16 = i15 + 1;
                                try {
                                    arrayList.add(i15, (g) Class.forName("androidx.media3.decoder.iamf.LibiamfAudioRenderer").getConstructor(Context.class, Handler.class, c2.j.class, c2.q.class).newInstance(objArr3));
                                    s1.b.k("DefaultRenderersFactory", "Loaded LibiamfAudioRenderer.");
                                } catch (ClassNotFoundException unused15) {
                                    i15 = i16;
                                    i16 = i15;
                                }
                            } catch (Exception e14) {
                                throw new IllegalStateException("Error instantiating IAMF extension", e14);
                            }
                        } catch (ClassNotFoundException unused16) {
                        }
                        try {
                            arrayList.add(i16, (g) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, c2.j.class, c2.q.class).newInstance(handler, l0Var2, e0Var));
                            s1.b.k("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                        } catch (ClassNotFoundException unused17) {
                        } catch (Exception e15) {
                            throw new IllegalStateException("Error instantiating MPEG-H extension", e15);
                        }
                    } catch (Exception e16) {
                        throw new IllegalStateException("Error instantiating FFmpeg extension", e16);
                    }
                } catch (Exception e17) {
                    throw new IllegalStateException("Error instantiating FLAC extension", e17);
                }
            } catch (Exception e18) {
                throw new IllegalStateException("Error instantiating Opus extension", e18);
            }
        }
        arrayList.add(new q2.f(l0Var3, handler.getLooper()));
        Looper looper = handler.getLooper();
        arrayList.add(new k2.b(l0Var4, looper));
        arrayList.add(new k2.b(l0Var4, looper));
        arrayList.add(new v2.b());
        arrayList.add(new i2.f(new c7.k(context)));
        return (g[]) arrayList.toArray(new g[0]);
    }
}
