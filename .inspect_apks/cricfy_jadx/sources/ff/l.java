package ff;

import android.content.res.AssetManager;
import android.os.Build;
import com.google.android.gms.internal.measurement.o4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Serializable f4595e;
    public final Serializable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f4596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Serializable f4597h;

    /* JADX WARN: Multi-variable type inference failed */
    public l(o4 o4Var, ef.b bVar, o oVar, l[] lVarArr) {
        ge.i.e(o4Var, "composer");
        this.f4593c = o4Var;
        this.f4594d = bVar;
        this.f4595e = oVar;
        this.f = lVarArr;
        this.f4596g = bVar.f3893a;
        int iOrdinal = oVar.ordinal();
        if (lVarArr != 0) {
            Object[] objArr = lVarArr[iOrdinal];
            if (objArr == 0 && objArr == this) {
                return;
            }
            lVarArr[iOrdinal] = this;
        }
    }

    public l a(bf.d dVar) {
        l lVar;
        l[] lVarArr = (l[]) this.f;
        ge.i.e(dVar, "descriptor");
        ef.b bVar = (ef.b) this.f4594d;
        o oVarF = i.f(dVar, bVar);
        char c9 = oVarF.f4608v;
        o4 o4Var = (o4) this.f4593c;
        o4Var.i(c9);
        o4Var.f2560v = true;
        String str = this.f4591a;
        if (str != null) {
            String strB = (String) this.f4597h;
            if (strB == null) {
                strB = dVar.b();
            }
            o4Var.h();
            j(str);
            o4Var.i(':');
            j(strB);
            this.f4591a = null;
            this.f4597h = null;
        }
        return ((o) this.f4595e) == oVarF ? this : (lVarArr == null || (lVar = lVarArr[oVarF.ordinal()]) == null) ? new l(o4Var, bVar, oVarF, lVarArr) : lVar;
    }

    public void b(bf.d dVar, int i) {
        o4 o4Var = (o4) this.f4593c;
        ge.i.e(dVar, "descriptor");
        int iOrdinal = ((o) this.f4595e).ordinal();
        boolean z10 = true;
        if (iOrdinal == 1) {
            if (!o4Var.f2560v) {
                o4Var.i(',');
            }
            o4Var.h();
            return;
        }
        if (iOrdinal == 2) {
            if (o4Var.f2560v) {
                this.f4592b = true;
                o4Var.h();
                return;
            }
            if (i % 2 == 0) {
                o4Var.i(',');
                o4Var.h();
            } else {
                o4Var.i(':');
                o4Var.k();
                z10 = false;
            }
            this.f4592b = z10;
            return;
        }
        if (iOrdinal != 3) {
            if (!o4Var.f2560v) {
                o4Var.i(',');
            }
            o4Var.h();
            i.e(dVar, (ef.b) this.f4594d);
            j(dVar.e(i));
            o4Var.i(':');
            o4Var.k();
            return;
        }
        if (i == 0) {
            this.f4592b = true;
        }
        if (i == 1) {
            o4Var.i(',');
            o4Var.k();
            this.f4592b = false;
        }
    }

    public void c(int i) {
        if (this.f4592b) {
            j(String.valueOf(i));
        } else {
            ((ag.o) ((o4) this.f4593c).f2561w).o(String.valueOf(i));
        }
    }

    public void d(long j4) {
        if (this.f4592b) {
            j(String.valueOf(j4));
        } else {
            ((ag.o) ((o4) this.f4593c).f2561w).o(String.valueOf(j4));
        }
    }

    public void e(bf.d dVar, int i, long j4) {
        ge.i.e(dVar, "descriptor");
        b(dVar, i);
        d(j4);
    }

    public void f() {
        o4 o4Var = (o4) this.f4593c;
        o4Var.getClass();
        ge.i.e("null", "v");
        ((ag.o) o4Var.f2561w).o("null");
    }

    public void g(bf.d dVar, int i, ze.a aVar, Object obj) {
        ge.i.e(dVar, "descriptor");
        ge.i.e(aVar, "serializer");
        if (obj != null || ((da.a) this.f4596g).f3562b) {
            ge.i.e(dVar, "descriptor");
            ge.i.e(aVar, "serializer");
            b(dVar, i);
            if (aVar.d().h()) {
                i(aVar, obj);
            } else if (obj == null) {
                f();
            } else {
                i(aVar, obj);
            }
        }
    }

    public void h(bf.d dVar, int i, ze.a aVar, Object obj) {
        ge.i.e(dVar, "descriptor");
        ge.i.e(aVar, "serializer");
        b(dVar, i);
        i(aVar, obj);
    }

    public void i(ze.a aVar, Object obj) {
        String strDiscriminator;
        ge.i.e(aVar, "serializer");
        da.a aVar2 = ((ef.b) this.f4594d).f3893a;
        aVar2.getClass();
        int iOrdinal = ((ef.a) aVar2.f).ordinal();
        if (iOrdinal == 0) {
            strDiscriminator = null;
        } else {
            if (iOrdinal == 1) {
                w8.e eVarC = aVar.d().c();
                if (ge.i.a(eVarC, bf.f.f1914d) || ge.i.a(eVarC, bf.f.f1916g)) {
                    bf.d dVarD = aVar.d();
                    ge.i.e(dVarD, "<this>");
                    Iterator it = dVarD.getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strDiscriminator = (String) aVar2.f3565e;
                            break;
                        }
                        Annotation annotation = (Annotation) it.next();
                        if (annotation instanceof ef.c) {
                            strDiscriminator = ((ef.c) annotation).discriminator();
                            break;
                        }
                    }
                }
            } else if (iOrdinal != 2) {
                throw new a9.l();
            }
            strDiscriminator = null;
        }
        if (strDiscriminator != null) {
            String strB = aVar.d().b();
            this.f4591a = strDiscriminator;
            this.f4597h = strB;
        }
        aVar.c(this, obj);
    }

    public void j(String str) {
        byte b8;
        ge.i.e(str, "value");
        o4 o4Var = (o4) this.f4593c;
        o4Var.getClass();
        ge.i.e(str, "value");
        ag.o oVar = (ag.o) o4Var.f2561w;
        oVar.f(oVar.f454w, str.length() + 2);
        char[] cArr = (char[]) oVar.f455x;
        int i = oVar.f454w;
        int i10 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        int i11 = length + i10;
        int i12 = i10;
        while (i12 < i11) {
            char c9 = cArr[i12];
            byte[] bArr = n.f4604b;
            if (c9 < bArr.length && bArr[c9] != 0) {
                int length2 = str.length();
                for (int i13 = i12 - i10; i13 < length2; i13++) {
                    oVar.f(i12, 2);
                    char cCharAt = str.charAt(i13);
                    byte[] bArr2 = n.f4604b;
                    if (cCharAt >= bArr2.length || (b8 = bArr2[cCharAt]) == 0) {
                        int i14 = i12 + 1;
                        ((char[]) oVar.f455x)[i12] = cCharAt;
                        i12 = i14;
                    } else {
                        if (b8 == 1) {
                            String str2 = n.f4603a[cCharAt];
                            ge.i.b(str2);
                            oVar.f(i12, str2.length());
                            str2.getChars(0, str2.length(), (char[]) oVar.f455x, i12);
                            int length3 = str2.length() + i12;
                            oVar.f454w = length3;
                            i12 = length3;
                        } else {
                            char[] cArr2 = (char[]) oVar.f455x;
                            cArr2[i12] = '\\';
                            cArr2[i12 + 1] = (char) b8;
                            i12 += 2;
                            oVar.f454w = i12;
                        }
                    }
                }
                oVar.f(i12, 1);
                ((char[]) oVar.f455x)[i12] = '\"';
                oVar.f454w = i12 + 1;
                return;
            }
            i12++;
        }
        cArr[i11] = '\"';
        oVar.f454w = i11 + 1;
    }

    public void k(bf.d dVar, int i, String str) {
        ge.i.e(dVar, "descriptor");
        ge.i.e(str, "value");
        b(dVar, i);
        j(str);
    }

    public void l(bf.d dVar) {
        ge.i.e(dVar, "descriptor");
        o oVar = (o) this.f4595e;
        o4 o4Var = (o4) this.f4593c;
        o4Var.getClass();
        o4Var.f2560v = false;
        o4Var.i(oVar.f4609w);
    }

    public FileInputStream m(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e9) {
            String message = e9.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((t4.b) this.f4594d).h();
            return null;
        }
    }

    public void n(int i, Serializable serializable) {
        ((Executor) this.f4593c).execute(new c.k(this, i, serializable, 4));
    }

    public boolean o(bf.d dVar) {
        ((da.a) this.f4596g).getClass();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public l(AssetManager assetManager, Executor executor, t4.b bVar, String str, File file) {
        this.f4592b = false;
        this.f4593c = executor;
        this.f4594d = bVar;
        this.f4591a = str;
        this.f = file;
        int i = Build.VERSION.SDK_INT;
        ?? r32 = 0;
        r32 = 0;
        if (i >= 24) {
            if (i >= 31) {
                r32 = t4.c.f11916d;
            } else {
                switch (i) {
                    case 24:
                    case 25:
                        r32 = t4.c.f11919h;
                        break;
                    case 26:
                        r32 = t4.c.f11918g;
                        break;
                    case 27:
                        r32 = t4.c.f;
                        break;
                    case 28:
                    case 29:
                    case 30:
                        r32 = t4.c.f11917e;
                        break;
                }
            }
        }
        this.f4595e = r32;
    }
}
