package g2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ad.b f4789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4790c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4791d;

    public l(Context context) {
        this.f4788a = context;
        this.f4789b = new ad.b(context, false);
    }

    public final e[] a(Handler handler, d0 d0Var, d0 d0Var2, d0 d0Var3, d0 d0Var4) {
        int i;
        Integer num;
        int i10;
        int i11;
        boolean z10;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Constructor constructor;
        Object[] objArr;
        Constructor<?> constructor2;
        Object[] objArr2;
        ArrayList arrayList = new ArrayList();
        int i17 = this.f4790c;
        boolean z11 = this.f4791d;
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Long.TYPE;
        Context context = this.f4788a;
        y2.h hVar = new y2.h(context);
        ad.b bVar = this.f4789b;
        hVar.f14662c = bVar;
        hVar.f14663d = 5000L;
        hVar.f14664e = z11;
        hVar.f = handler;
        hVar.f14665g = d0Var;
        hVar.f14666h = 50;
        y1.d.g(!hVar.f14661b);
        Handler handler2 = hVar.f;
        y1.d.g((handler2 == null && hVar.f14665g == null) || !(handler2 == null || hVar.f14665g == null));
        hVar.f14661b = true;
        arrayList.add(new y2.j(hVar));
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
                        arrayList.add(i18, (e) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(cls2, Handler.class, y2.c0.class, cls).newInstance(5000L, handler, d0Var, 50));
                        y1.b.k("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused2) {
                        i18 = i10;
                        i10 = i18;
                    }
                } catch (Exception e9) {
                    throw new IllegalStateException("Error instantiating VP9 extension", e9);
                }
            } catch (ClassNotFoundException unused3) {
                num = 50;
            }
            try {
                try {
                    i11 = i10 + 1;
                    try {
                        arrayList.add(i10, (e) Class.forName("androidx.media3.decoder.av1.Libgav1VideoRenderer").getConstructor(cls2, Handler.class, y2.c0.class, cls).newInstance(5000L, handler, d0Var, num));
                        y1.b.k("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                    } catch (ClassNotFoundException unused4) {
                        i10 = i11;
                        i11 = i10;
                    }
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    arrayList.add(i11, (e) androidx.media3.decoder.ffmpeg.a.class.getConstructor(cls2, Handler.class, y2.c0.class, cls).newInstance(5000L, handler, d0Var, num));
                    y1.b.k("DefaultRenderersFactory", "Loaded FfmpegVideoRenderer.");
                } catch (ClassNotFoundException unused6) {
                } catch (Exception e10) {
                    throw new IllegalStateException("Error instantiating FFmpeg extension", e10);
                }
            } catch (Exception e11) {
                throw new IllegalStateException("Error instantiating AV1 extension", e11);
            }
        }
        i2.x xVar = new i2.x(context, 0);
        y1.d.g(!xVar.f6144b);
        xVar.f6144b = true;
        if (((androidx.emoji2.text.v) xVar.f6146d) == null) {
            xVar.f6146d = new androidx.emoji2.text.v(new w1.h[0]);
        }
        if (((i2.k) xVar.f6148g) == null) {
            z10 = true;
            xVar.f6148g = new i2.k(context, 1);
        } else {
            z10 = true;
        }
        i2.f0 f0Var = new i2.f0(xVar);
        int i19 = this.f4790c;
        boolean z12 = this.f4791d;
        Context context2 = this.f4788a;
        boolean z13 = z10;
        arrayList.add(new i2.h0(context2, bVar, z12, handler, d0Var2, f0Var));
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
                    clsArr[z13 ? 1 : 0] = Handler.class;
                    clsArr[2] = i2.l.class;
                    clsArr[i] = i2.s.class;
                    Constructor<?> constructor3 = cls3.getConstructor(clsArr);
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = context2;
                    objArr3[z13 ? 1 : 0] = handler;
                    objArr3[2] = d0Var2;
                    objArr3[i] = f0Var;
                    i12 = size2 + 1;
                    try {
                        arrayList.add(size2, (e) constructor3.newInstance(objArr3));
                        y1.b.k("DefaultRenderersFactory", "Loaded MidiRenderer.");
                    } catch (ClassNotFoundException unused7) {
                        size2 = i12;
                        i12 = size2;
                    }
                } catch (Exception e12) {
                    throw new IllegalStateException("Error instantiating MIDI extension", e12);
                }
            } catch (ClassNotFoundException unused8) {
            }
            try {
                try {
                    Class<?> cls4 = Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer");
                    int i20 = i;
                    Class<?>[] clsArr2 = new Class[i20];
                    clsArr2[0] = Handler.class;
                    clsArr2[z13 ? 1 : 0] = i2.l.class;
                    clsArr2[2] = i2.s.class;
                    constructor2 = cls4.getConstructor(clsArr2);
                    objArr2 = new Object[i20];
                    objArr2[0] = handler;
                    objArr2[z13 ? 1 : 0] = d0Var2;
                    objArr2[2] = f0Var;
                    i13 = i12 + 1;
                } catch (Exception e13) {
                    throw new IllegalStateException("Error instantiating Opus extension", e13);
                }
            } catch (ClassNotFoundException unused9) {
            }
            try {
                arrayList.add(i12, (e) constructor2.newInstance(objArr2));
                y1.b.k("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException unused10) {
                i12 = i13;
                i13 = i12;
            }
            try {
                try {
                    Class<?> cls5 = Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer");
                    Class<?>[] clsArr3 = new Class[3];
                    clsArr3[0] = Handler.class;
                    clsArr3[z13 ? 1 : 0] = i2.l.class;
                    clsArr3[2] = i2.s.class;
                    Constructor<?> constructor4 = cls5.getConstructor(clsArr3);
                    Object[] objArr4 = new Object[3];
                    objArr4[0] = handler;
                    objArr4[z13 ? 1 : 0] = d0Var2;
                    objArr4[2] = f0Var;
                    i14 = i13 + 1;
                    try {
                        arrayList.add(i13, (e) constructor4.newInstance(objArr4));
                        y1.b.k("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    } catch (ClassNotFoundException unused11) {
                        i13 = i14;
                        i14 = i13;
                    }
                } catch (ClassNotFoundException unused12) {
                }
                try {
                    try {
                        Class[] clsArr4 = new Class[3];
                        clsArr4[0] = Handler.class;
                        clsArr4[z13 ? 1 : 0] = i2.l.class;
                        clsArr4[2] = i2.s.class;
                        constructor = androidx.media3.decoder.ffmpeg.c.class.getConstructor(clsArr4);
                        objArr = new Object[3];
                        objArr[0] = handler;
                        objArr[z13 ? 1 : 0] = d0Var2;
                        objArr[2] = f0Var;
                        i15 = i14 + 1;
                    } catch (ClassNotFoundException unused13) {
                    }
                    try {
                        arrayList.add(i14, (e) constructor.newInstance(objArr));
                        y1.b.k("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                    } catch (ClassNotFoundException unused14) {
                        i14 = i15;
                        i15 = i14;
                    }
                    try {
                        try {
                            Class<?> cls6 = Class.forName("androidx.media3.decoder.iamf.LibiamfAudioRenderer");
                            Class<?>[] clsArr5 = new Class[4];
                            clsArr5[0] = Context.class;
                            clsArr5[z13 ? 1 : 0] = Handler.class;
                            clsArr5[2] = i2.l.class;
                            clsArr5[3] = i2.s.class;
                            Constructor<?> constructor5 = cls6.getConstructor(clsArr5);
                            Object[] objArr5 = new Object[4];
                            objArr5[0] = context2;
                            objArr5[z13 ? 1 : 0] = handler;
                            objArr5[2] = d0Var2;
                            objArr5[3] = f0Var;
                            i16 = i15 + 1;
                            try {
                                arrayList.add(i15, (e) constructor5.newInstance(objArr5));
                                y1.b.k("DefaultRenderersFactory", "Loaded LibiamfAudioRenderer.");
                            } catch (ClassNotFoundException unused15) {
                                i15 = i16;
                                i16 = i15;
                            }
                        } catch (ClassNotFoundException unused16) {
                        }
                        try {
                            Class<?> cls7 = Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer");
                            Class<?>[] clsArr6 = new Class[3];
                            clsArr6[0] = Handler.class;
                            clsArr6[z13 ? 1 : 0] = i2.l.class;
                            clsArr6[2] = i2.s.class;
                            Constructor<?> constructor6 = cls7.getConstructor(clsArr6);
                            Object[] objArr6 = new Object[3];
                            objArr6[0] = handler;
                            objArr6[z13 ? 1 : 0] = d0Var2;
                            objArr6[2] = f0Var;
                            arrayList.add(i16, (e) constructor6.newInstance(objArr6));
                            y1.b.k("DefaultRenderersFactory", "Loaded MpeghAudioRenderer.");
                        } catch (ClassNotFoundException unused17) {
                        } catch (Exception e14) {
                            throw new IllegalStateException("Error instantiating MPEG-H extension", e14);
                        }
                    } catch (Exception e15) {
                        throw new IllegalStateException("Error instantiating IAMF extension", e15);
                    }
                } catch (Exception e16) {
                    throw new IllegalStateException("Error instantiating FFmpeg extension", e16);
                }
            } catch (Exception e17) {
                throw new IllegalStateException("Error instantiating FLAC extension", e17);
            }
        }
        arrayList.add(new u2.e(d0Var3, handler.getLooper()));
        Looper looper = handler.getLooper();
        arrayList.add(new q2.b(d0Var4, looper));
        arrayList.add(new q2.b(d0Var4, looper));
        arrayList.add(new z2.b());
        arrayList.add(new o2.g(new b7.e(context)));
        return (e[]) arrayList.toArray(new e[0]);
    }
}
