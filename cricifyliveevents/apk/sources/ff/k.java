package ff;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g2.g0;
import g2.z;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import o.n1;
import o.r;
import t0.d0;
import t0.m0;
import v4.x;
import y1.a0;
import y1.t;
import y1.v;
import z1.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f4590e;
    public Object f;

    public k(ef.b bVar, o oVar, m mVar, bf.d dVar) {
        ge.i.e(dVar, "descriptor");
        this.f4587b = bVar;
        this.f4588c = oVar;
        this.f4589d = mVar;
        this.f4586a = -1;
        da.a aVar = bVar.f3893a;
        this.f4590e = aVar;
        this.f = aVar.f3562b ? null : new f(dVar);
    }

    public v4.a A(Object obj, int i, int i10, int i11) {
        v4.a aVar = (v4.a) ((s0.d) this.f4587b).i();
        if (aVar != null) {
            aVar.f13174a = i;
            aVar.f13175b = i10;
            aVar.f13177d = i11;
            aVar.f13176c = obj;
            return aVar;
        }
        v4.a aVar2 = new v4.a();
        aVar2.f13174a = i;
        aVar2.f13175b = i10;
        aVar2.f13177d = i11;
        aVar2.f13176c = obj;
        return aVar2;
    }

    public void B() {
        this.f4586a = -1;
        H(null);
        b();
    }

    public void C(int i) {
        ColorStateList colorStateListI;
        this.f4586a = i;
        r rVar = (r) this.f4588c;
        if (rVar != null) {
            Context context = ((View) this.f4587b).getContext();
            synchronized (rVar) {
                colorStateListI = rVar.f9337a.i(context, i);
            }
        } else {
            colorStateListI = null;
        }
        H(colorStateListI);
        b();
    }

    public void D(v4.a aVar) {
        x xVar = (x) this.f4590e;
        ((ArrayList) this.f4589d).add(aVar);
        int i = aVar.f13174a;
        if (i == 1) {
            xVar.d(aVar.f13175b, aVar.f13177d);
            return;
        }
        if (i == 2) {
            int i10 = aVar.f13175b;
            int i11 = aVar.f13177d;
            RecyclerView recyclerView = xVar.f13385a;
            recyclerView.S(i10, i11, false);
            recyclerView.E0 = true;
            return;
        }
        if (i == 4) {
            xVar.c(aVar.f13175b, aVar.f13177d, aVar.f13176c);
        } else if (i == 8) {
            xVar.e(aVar.f13175b, aVar.f13177d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E() {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ff.k.E():void");
    }

    public void F(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v4.a aVar = (v4.a) arrayList.get(i);
            aVar.f13176c = null;
            ((s0.d) this.f4587b).b(aVar);
        }
        arrayList.clear();
    }

    public void G(Runnable runnable) {
        y1.x xVar = (y1.x) this.f4587b;
        if (xVar.f14618a.getLooper().getThread().isAlive()) {
            xVar.c(runnable);
        }
    }

    public void H(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((kf.j) this.f4589d) == null) {
                this.f4589d = new kf.j();
            }
            kf.j jVar = (kf.j) this.f4589d;
            jVar.f7486c = colorStateList;
            jVar.f7485b = true;
        } else {
            this.f4589d = null;
        }
        b();
    }

    public void I(int i) {
        y1.d.g(i >= 0);
        this.f4586a = i;
        v(i);
    }

    public void J(ColorStateList colorStateList) {
        if (((kf.j) this.f4590e) == null) {
            this.f4590e = new kf.j();
        }
        kf.j jVar = (kf.j) this.f4590e;
        jVar.f7486c = colorStateList;
        jVar.f7485b = true;
        b();
    }

    public void K(PorterDuff.Mode mode) {
        if (((kf.j) this.f4590e) == null) {
            this.f4590e = new kf.j();
        }
        kf.j jVar = (kf.j) this.f4590e;
        jVar.f7487d = mode;
        jVar.f7484a = true;
        b();
    }

    public int L(int i, int i10) {
        int i11;
        int i12;
        s0.d dVar = (s0.d) this.f4587b;
        ArrayList arrayList = (ArrayList) this.f4589d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            v4.a aVar = (v4.a) arrayList.get(size);
            int i13 = aVar.f13174a;
            if (i13 == 8) {
                int i14 = aVar.f13175b;
                int i15 = aVar.f13177d;
                if (i14 < i15) {
                    i12 = i14;
                    i11 = i15;
                } else {
                    i11 = i14;
                    i12 = i15;
                }
                if (i < i12 || i > i11) {
                    if (i < i14) {
                        if (i10 == 1) {
                            aVar.f13175b = i14 + 1;
                            aVar.f13177d = i15 + 1;
                        } else if (i10 == 2) {
                            aVar.f13175b = i14 - 1;
                            aVar.f13177d = i15 - 1;
                        }
                    }
                } else if (i12 == i14) {
                    if (i10 == 1) {
                        aVar.f13177d = i15 + 1;
                    } else if (i10 == 2) {
                        aVar.f13177d = i15 - 1;
                    }
                    i++;
                } else {
                    if (i10 == 1) {
                        aVar.f13175b = i14 + 1;
                    } else if (i10 == 2) {
                        aVar.f13175b = i14 - 1;
                    }
                    i--;
                }
            } else {
                int i16 = aVar.f13175b;
                if (i16 <= i) {
                    if (i13 == 1) {
                        i -= aVar.f13177d;
                    } else if (i13 == 2) {
                        i += aVar.f13177d;
                    }
                } else if (i10 == 1) {
                    aVar.f13175b = i16 + 1;
                } else if (i10 == 2) {
                    aVar.f13175b = i16 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            v4.a aVar2 = (v4.a) arrayList.get(size2);
            if (aVar2.f13174a == 8) {
                int i17 = aVar2.f13177d;
                if (i17 == aVar2.f13175b || i17 < 0) {
                    arrayList.remove(size2);
                    aVar2.f13176c = null;
                    dVar.b(aVar2);
                }
            } else if (aVar2.f13177d <= 0) {
                arrayList.remove(size2);
                aVar2.f13176c = null;
                dVar.b(aVar2);
            }
        }
        return i;
    }

    public void M(Object obj) {
        Object obj2 = this.f4590e;
        this.f4590e = obj;
        if (obj2.equals(obj)) {
            return;
        }
        g0 g0Var = ((z) this.f4589d).f4951w;
        ((Integer) obj2).getClass();
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        g0Var.P1();
        g0Var.G1(1, 10, num);
        g0Var.G1(2, 10, num);
        g0Var.I.e(21, new g2.x(iIntValue, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r9 < r2.f15129w) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r9, y1.t r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f4589d
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0
            java.lang.Object r1 = r8.f4590e
            java.util.PriorityQueue r1 = (java.util.PriorityQueue) r1
            int r2 = r8.f4586a
            if (r2 == 0) goto L9e
            r3 = -1
            if (r2 == r3) goto L27
            int r2 = r1.size()
            int r4 = r8.f4586a
            if (r2 < r4) goto L27
            java.lang.Object r2 = r1.peek()
            z1.r r2 = (z1.r) r2
            int r4 = y1.a0.f14551a
            long r4 = r2.f15129w
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 >= 0) goto L27
            goto L9e
        L27:
            java.lang.Object r2 = r8.f4588c
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L37
            y1.t r2 = new y1.t
            r2.<init>()
            goto L3d
        L37:
            java.lang.Object r2 = r2.pop()
            y1.t r2 = (y1.t) r2
        L3d:
            int r4 = r11.a()
            r2.G(r4)
            byte[] r4 = r11.f14609a
            int r11 = r11.f14610b
            byte[] r5 = r2.f14609a
            int r6 = r2.a()
            r7 = 0
            java.lang.System.arraycopy(r4, r11, r5, r7, r6)
            java.lang.Object r11 = r8.f
            z1.r r11 = (z1.r) r11
            if (r11 == 0) goto L64
            long r4 = r11.f15129w
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 != 0) goto L64
            java.util.ArrayList r9 = r11.f15128v
            r9.add(r2)
            return
        L64:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L70
            z1.r r11 = new z1.r
            r11.<init>()
            goto L76
        L70:
            java.lang.Object r11 = r0.pop()
            z1.r r11 = (z1.r) r11
        L76:
            java.util.ArrayList r0 = r11.f15128v
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 == 0) goto L82
            r7 = 1
        L82:
            y1.d.b(r7)
            boolean r4 = r0.isEmpty()
            y1.d.g(r4)
            r11.f15129w = r9
            r0.add(r2)
            r1.add(r11)
            r8.f = r11
            int r9 = r8.f4586a
            if (r9 == r3) goto L9d
            r8.v(r9)
        L9d:
            return
        L9e:
            java.lang.Object r0 = r8.f4587b
            z1.s r0 = (z1.s) r0
            r0.c(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ff.k.a(long, y1.t):void");
    }

    public void b() {
        View view = (View) this.f4587b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((kf.j) this.f4589d) != null) {
                if (((kf.j) this.f) == null) {
                    this.f = new kf.j();
                }
                kf.j jVar = (kf.j) this.f;
                jVar.f7486c = null;
                jVar.f7485b = false;
                jVar.f7487d = null;
                jVar.f7484a = false;
                WeakHashMap weakHashMap = m0.f11777a;
                ColorStateList colorStateListC = d0.c(view);
                if (colorStateListC != null) {
                    jVar.f7485b = true;
                    jVar.f7486c = colorStateListC;
                }
                PorterDuff.Mode modeD = d0.d(view);
                if (modeD != null) {
                    jVar.f7484a = true;
                    jVar.f7487d = modeD;
                }
                if (jVar.f7485b || jVar.f7484a) {
                    r.e(background, jVar, view.getDrawableState());
                    return;
                }
            }
            kf.j jVar2 = (kf.j) this.f4590e;
            if (jVar2 != null) {
                r.e(background, jVar2, view.getDrawableState());
                return;
            }
            kf.j jVar3 = (kf.j) this.f4589d;
            if (jVar3 != null) {
                r.e(background, jVar3, view.getDrawableState());
            }
        }
    }

    public k c(bf.d dVar) {
        byte b8;
        ge.i.e(dVar, "descriptor");
        ef.b bVar = (ef.b) this.f4587b;
        o oVarF = i.f(dVar, bVar);
        m mVar = (m) this.f4589d;
        f3.a aVar = (f3.a) mVar.f4600x;
        int i = aVar.f3935w + 1;
        aVar.f3935w = i;
        Object[] objArr = (Object[]) aVar.f3936x;
        if (i == objArr.length) {
            int i10 = i * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i10);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            aVar.f3936x = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf((int[]) aVar.f3937y, i10);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            aVar.f3937y = iArrCopyOf;
        }
        ((Object[]) aVar.f3936x)[i] = dVar;
        mVar.j(oVarF.f4608v);
        String str = (String) mVar.f4602z;
        int i11 = mVar.f4599w;
        while (true) {
            int iA = mVar.A(i11);
            b8 = 10;
            if (iA == -1) {
                mVar.f4599w = iA;
                break;
            }
            char cCharAt = str.charAt(iA);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                mVar.f4599w = iA;
                b8 = i.b(cCharAt);
                break;
            }
            i11 = iA + 1;
        }
        if (b8 != 4) {
            int iOrdinal = oVarF.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new k(bVar, oVarF, mVar, dVar) : (((o) this.f4588c) == oVarF && bVar.f3893a.f3562b) ? this : new k(bVar, oVarF, mVar, dVar);
        }
        m.q(mVar, "Unexpected leading comma", 0, 6);
        throw null;
    }

    public boolean d(int i) {
        ArrayList arrayList = (ArrayList) this.f4589d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            v4.a aVar = (v4.a) arrayList.get(i10);
            int i11 = aVar.f13174a;
            if (i11 != 8) {
                if (i11 == 1) {
                    int i12 = aVar.f13175b;
                    int i13 = aVar.f13177d + i12;
                    while (i12 < i13) {
                        if (u(i12, i10 + 1) == i) {
                            return true;
                        }
                        i12++;
                    }
                } else {
                    continue;
                }
            } else {
                if (u(aVar.f13177d, i10 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void e() {
        ArrayList arrayList = (ArrayList) this.f4589d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((x) this.f4590e).a((v4.a) arrayList.get(i));
        }
        F(arrayList);
        this.f4586a = 0;
    }

    public void f() {
        x xVar = (x) this.f4590e;
        e();
        ArrayList arrayList = (ArrayList) this.f4588c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v4.a aVar = (v4.a) arrayList.get(i);
            int i10 = aVar.f13174a;
            if (i10 == 1) {
                xVar.a(aVar);
                xVar.d(aVar.f13175b, aVar.f13177d);
            } else if (i10 == 2) {
                xVar.a(aVar);
                int i11 = aVar.f13175b;
                int i12 = aVar.f13177d;
                RecyclerView recyclerView = xVar.f13385a;
                recyclerView.S(i11, i12, true);
                recyclerView.E0 = true;
                recyclerView.B0.f13363c += i12;
            } else if (i10 == 4) {
                xVar.a(aVar);
                xVar.c(aVar.f13175b, aVar.f13177d, aVar.f13176c);
            } else if (i10 == 8) {
                xVar.a(aVar);
                xVar.e(aVar.f13175b, aVar.f13177d);
            }
        }
        F(arrayList);
        this.f4586a = 0;
    }

    public int g(bf.d dVar) {
        ef.b bVar = (ef.b) this.f4587b;
        da.a aVar = bVar.f3893a;
        m mVar = (m) this.f4589d;
        ge.i.e(dVar, "descriptor");
        o oVar = (o) this.f4588c;
        int iOrdinal = oVar.ordinal();
        int i = 0;
        zC = false;
        boolean zC = false;
        int iIntValue = -1;
        if (iOrdinal == 0) {
            f fVar = (f) this.f;
            da.a aVar2 = (da.a) this.f4590e;
            boolean zC2 = mVar.C();
            if (mVar.g()) {
                aVar2.getClass();
                String strI = mVar.i();
                mVar.j(':');
                ge.i.e(dVar, "<this>");
                ge.i.e(bVar, "json");
                ge.i.e(strI, "name");
                da.a aVar3 = bVar.f3893a;
                aVar3.getClass();
                i.e(dVar, bVar);
                int iA = dVar.a(strI);
                iIntValue = -3;
                if (iA == -3 && aVar3.f3563c) {
                    p6.c cVar = bVar.f3895c;
                    h hVar = new h(0, dVar, bVar);
                    cVar.getClass();
                    cVar.getClass();
                    ge.i.e(dVar, "descriptor");
                    Map map = (Map) ((ConcurrentHashMap) cVar.f10035w).get(dVar);
                    j jVar = i.f4584a;
                    Object obj = map != null ? map.get(jVar) : null;
                    Object objB = obj != null ? obj : null;
                    if (objB == null) {
                        objB = hVar.b();
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) cVar.f10035w;
                        Object obj2 = concurrentHashMap.get(dVar);
                        Object obj3 = obj2;
                        if (obj2 == null) {
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(2);
                            concurrentHashMap.put(dVar, concurrentHashMap2);
                            obj3 = concurrentHashMap2;
                        }
                        ((Map) obj3).put(jVar, objB);
                    }
                    Integer num = (Integer) ((Map) objB).get(strI);
                    if (num != null) {
                        iIntValue = num.intValue();
                    }
                } else {
                    iIntValue = iA;
                }
                if (iIntValue == -3) {
                    mVar.p(ne.h.m0(((String) mVar.f4602z).subSequence(0, mVar.f4599w).toString(), strI), "Encountered an unknown key '" + strI + '\'', "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
                    throw null;
                }
                if (fVar != null) {
                    df.d dVar2 = fVar.f4579a;
                    if (iIntValue < 64) {
                        dVar2.f3700c |= 1 << iIntValue;
                    } else {
                        int i10 = (iIntValue >>> 6) - 1;
                        long[] jArr = dVar2.f3701d;
                        jArr[i10] = jArr[i10] | (1 << (iIntValue & 63));
                    }
                }
            } else {
                if (zC2) {
                    aVar.getClass();
                    i.c(mVar, "object");
                    throw null;
                }
                if (fVar != null) {
                    df.d dVar3 = fVar.f4579a;
                    e eVar = dVar3.f3699b;
                    bf.d dVar4 = dVar3.f3698a;
                    int iD = dVar4.d();
                    while (true) {
                        long j4 = dVar3.f3700c;
                        if (j4 != -1) {
                            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j4);
                            dVar3.f3700c |= 1 << iNumberOfTrailingZeros;
                            if (((Boolean) eVar.j(dVar4, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue()) {
                                iIntValue = iNumberOfTrailingZeros;
                                break;
                            }
                        } else if (iD > 64) {
                            long[] jArr2 = dVar3.f3701d;
                            int length = jArr2.length;
                            loop1: while (true) {
                                if (i >= length) {
                                    break;
                                }
                                int i11 = i + 1;
                                int i12 = i11 * 64;
                                long j7 = jArr2[i];
                                while (j7 != -1) {
                                    long[] jArr3 = jArr2;
                                    int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j7);
                                    j7 |= 1 << iNumberOfTrailingZeros2;
                                    int i13 = iNumberOfTrailingZeros2 + i12;
                                    if (((Boolean) eVar.j(dVar4, Integer.valueOf(i13))).booleanValue()) {
                                        jArr3[i] = j7;
                                        iIntValue = i13;
                                        break loop1;
                                    }
                                    jArr2 = jArr3;
                                }
                                jArr2[i] = j7;
                                i = i11;
                            }
                        }
                    }
                }
            }
        } else if (iOrdinal != 2) {
            boolean zC3 = mVar.C();
            if (mVar.g()) {
                int i14 = this.f4586a;
                if (i14 != -1 && !zC3) {
                    m.q(mVar, "Expected end of the array or comma", 0, 6);
                    throw null;
                }
                iIntValue = i14 + 1;
                this.f4586a = iIntValue;
            } else if (zC3) {
                aVar.getClass();
                i.c(mVar, "array");
                throw null;
            }
        } else {
            int i15 = this.f4586a;
            boolean z10 = i15 % 2 != 0;
            if (!z10) {
                mVar.j(':');
            } else if (i15 != -1) {
                zC = mVar.C();
            }
            if (mVar.g()) {
                if (z10) {
                    if (this.f4586a == -1) {
                        int i16 = mVar.f4599w;
                        if (zC) {
                            m.q(mVar, "Unexpected leading comma", i16, 4);
                            throw null;
                        }
                    } else {
                        int i17 = mVar.f4599w;
                        if (!zC) {
                            m.q(mVar, "Expected comma after the key-value pair", i17, 4);
                            throw null;
                        }
                    }
                }
                iIntValue = this.f4586a + 1;
                this.f4586a = iIntValue;
            } else if (zC) {
                aVar.getClass();
                i.c(mVar, "object");
                throw null;
            }
        }
        if (oVar != o.f4607z) {
            f3.a aVar4 = (f3.a) mVar.f4600x;
            ((int[]) aVar4.f3937y)[aVar4.f3935w] = iIntValue;
        }
        return iIntValue;
    }

    public int h() {
        m mVar = (m) this.f4589d;
        long jK = mVar.k();
        int i = (int) jK;
        if (jK == i) {
            return i;
        }
        m.q(mVar, "Failed to parse int for input '" + jK + '\'', 0, 6);
        throw null;
    }

    public int i(bf.d dVar, int i) {
        ge.i.e(dVar, "descriptor");
        return h();
    }

    public long j() {
        return ((m) this.f4589d).k();
    }

    public long k(bf.d dVar, int i) {
        ge.i.e(dVar, "descriptor");
        return j();
    }

    public boolean l() {
        f fVar = (f) this.f;
        if (!(fVar != null ? fVar.f4580b : false)) {
            m mVar = (m) this.f4589d;
            int iA = mVar.A(mVar.B());
            String str = (String) mVar.f4602z;
            int length = str.length() - iA;
            boolean z10 = false;
            if (length >= 4 && iA != -1) {
                int i = 0;
                while (true) {
                    if (i < 4) {
                        if ("null".charAt(i) != str.charAt(iA + i)) {
                            break;
                        }
                        i++;
                    } else if (length <= 4 || i.b(str.charAt(iA + 4)) != 0) {
                        z10 = true;
                        mVar.f4599w = iA + 4;
                    }
                }
            }
            if (!z10) {
                return true;
            }
        }
        return false;
    }

    public Object m(bf.d dVar, int i, ze.a aVar, Object obj) {
        ge.i.e(dVar, "descriptor");
        ge.i.e(aVar, "deserializer");
        if (aVar.d().h() || l()) {
            return o(aVar);
        }
        return null;
    }

    public Object n(bf.d dVar, int i, ze.a aVar, Object obj) {
        f3.a aVar2 = (f3.a) ((m) this.f4589d).f4600x;
        ge.i.e(dVar, "descriptor");
        ge.i.e(aVar, "deserializer");
        boolean z10 = ((o) this.f4588c) == o.f4607z && (i & 1) == 0;
        if (z10) {
            int[] iArr = (int[]) aVar2.f3937y;
            int i10 = aVar2.f3935w;
            if (iArr[i10] == -2) {
                ((Object[]) aVar2.f3936x)[i10] = j.f4585a;
            }
        }
        ge.i.e(dVar, "descriptor");
        ge.i.e(aVar, "deserializer");
        Object objO = o(aVar);
        if (z10) {
            int[] iArr2 = (int[]) aVar2.f3937y;
            int i11 = aVar2.f3935w;
            if (iArr2[i11] != -2) {
                int i12 = i11 + 1;
                aVar2.f3935w = i12;
                Object[] objArr = (Object[]) aVar2.f3936x;
                if (i12 == objArr.length) {
                    int i13 = i12 * 2;
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, i13);
                    ge.i.d(objArrCopyOf, "copyOf(...)");
                    aVar2.f3936x = objArrCopyOf;
                    int[] iArrCopyOf = Arrays.copyOf((int[]) aVar2.f3937y, i13);
                    ge.i.d(iArrCopyOf, "copyOf(...)");
                    aVar2.f3937y = iArrCopyOf;
                }
            }
            Object[] objArr2 = (Object[]) aVar2.f3936x;
            int i14 = aVar2.f3935w;
            objArr2[i14] = objO;
            ((int[]) aVar2.f3937y)[i14] = -2;
        }
        return objO;
    }

    public Object o(ze.a aVar) {
        ge.i.e(aVar, "deserializer");
        try {
            return aVar.b(this);
        } catch (ze.b e9) {
            String message = e9.getMessage();
            ge.i.b(message);
            if (ne.h.c0(message, "at path", false)) {
                throw e9;
            }
            throw new ze.b(e9.f15342v, e9.getMessage() + " at path: " + ((f3.a) ((m) this.f4589d).f4600x).l(), e9);
        }
    }

    public String p() {
        m mVar = (m) this.f4589d;
        ((da.a) this.f4590e).getClass();
        return mVar.l();
    }

    public String q(bf.d dVar, int i) {
        ge.i.e(dVar, "descriptor");
        return p();
    }

    public void r(v4.a aVar) {
        int i;
        s0.d dVar = (s0.d) this.f4587b;
        int i10 = aVar.f13174a;
        if (i10 == 1 || i10 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iL = L(aVar.f13175b, i10);
        int i11 = aVar.f13175b;
        int i12 = aVar.f13174a;
        if (i12 == 2) {
            i = 0;
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aVar);
            }
            i = 1;
        }
        int i13 = 1;
        for (int i14 = 1; i14 < aVar.f13177d; i14++) {
            int iL2 = L((i * i14) + aVar.f13175b, aVar.f13174a);
            int i15 = aVar.f13174a;
            if (i15 == 2 ? iL2 != iL : !(i15 == 4 && iL2 == iL + 1)) {
                v4.a aVarA = A(aVar.f13176c, i15, iL, i13);
                s(aVarA, i11);
                aVarA.f13176c = null;
                dVar.b(aVarA);
                if (aVar.f13174a == 4) {
                    i11 += i13;
                }
                i13 = 1;
                iL = iL2;
            } else {
                i13++;
            }
        }
        Object obj = aVar.f13176c;
        aVar.f13176c = null;
        dVar.b(aVar);
        if (i13 > 0) {
            v4.a aVarA2 = A(obj, aVar.f13174a, iL, i13);
            s(aVarA2, i11);
            aVarA2.f13176c = null;
            dVar.b(aVarA2);
        }
    }

    public void s(v4.a aVar, int i) {
        x xVar = (x) this.f4590e;
        xVar.a(aVar);
        int i10 = aVar.f13174a;
        if (i10 != 2) {
            if (i10 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            xVar.c(i, aVar.f13177d, aVar.f13176c);
        } else {
            int i11 = aVar.f13177d;
            RecyclerView recyclerView = xVar.f13385a;
            recyclerView.S(i, i11, true);
            recyclerView.E0 = true;
            recyclerView.B0.f13363c += i11;
        }
    }

    public void t(bf.d dVar) {
        m mVar = (m) this.f4589d;
        ge.i.e(dVar, "descriptor");
        da.a aVar = ((ef.b) this.f4587b).f3893a;
        aVar.getClass();
        if (mVar.C()) {
            aVar.getClass();
            i.c(mVar, "");
            throw null;
        }
        mVar.j(((o) this.f4588c).f4609w);
        f3.a aVar2 = (f3.a) mVar.f4600x;
        int i = aVar2.f3935w;
        int[] iArr = (int[]) aVar2.f3937y;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            aVar2.f3935w = i - 1;
        }
        int i10 = aVar2.f3935w;
        if (i10 != -1) {
            aVar2.f3935w = i10 - 1;
        }
    }

    public int u(int i, int i10) {
        ArrayList arrayList = (ArrayList) this.f4589d;
        int size = arrayList.size();
        while (i10 < size) {
            v4.a aVar = (v4.a) arrayList.get(i10);
            int i11 = aVar.f13174a;
            if (i11 == 8) {
                int i12 = aVar.f13175b;
                if (i12 == i) {
                    i = aVar.f13177d;
                } else {
                    if (i12 < i) {
                        i--;
                    }
                    if (aVar.f13177d <= i) {
                        i++;
                    }
                }
            } else {
                int i13 = aVar.f13175b;
                if (i13 > i) {
                    continue;
                } else if (i11 == 2) {
                    int i14 = aVar.f13177d;
                    if (i < i13 + i14) {
                        return -1;
                    }
                    i -= i14;
                } else if (i11 == 1) {
                    i += aVar.f13177d;
                }
            }
            i10++;
        }
        return i;
    }

    public void v(int i) {
        ArrayList arrayList;
        PriorityQueue priorityQueue = (PriorityQueue) this.f4590e;
        while (priorityQueue.size() > i) {
            z1.r rVar = (z1.r) priorityQueue.poll();
            int i10 = a0.f14551a;
            int i11 = 0;
            while (true) {
                arrayList = rVar.f15128v;
                if (i11 >= arrayList.size()) {
                    break;
                }
                ((s) this.f4587b).c(rVar.f15129w, (t) arrayList.get(i11));
                ((ArrayDeque) this.f4588c).push((t) arrayList.get(i11));
                i11++;
            }
            arrayList.clear();
            z1.r rVar2 = (z1.r) this.f;
            if (rVar2 != null && rVar2.f15129w == rVar.f15129w) {
                this.f = null;
            }
            ((ArrayDeque) this.f4589d).push(rVar);
        }
    }

    public ColorStateList w() {
        kf.j jVar = (kf.j) this.f4590e;
        if (jVar != null) {
            return (ColorStateList) jVar.f7486c;
        }
        return null;
    }

    public PorterDuff.Mode x() {
        kf.j jVar = (kf.j) this.f4590e;
        if (jVar != null) {
            return (PorterDuff.Mode) jVar.f7487d;
        }
        return null;
    }

    public boolean y() {
        return ((ArrayList) this.f4588c).size() > 0;
    }

    public void z(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListI;
        View view = (View) this.f4587b;
        l7.a aVarF = l7.a.F(view.getContext(), attributeSet, g.j.ViewBackgroundHelper, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        View view2 = (View) this.f4587b;
        m0.m(view2, view2.getContext(), g.j.ViewBackgroundHelper, attributeSet, (TypedArray) aVarF.f7867x, i);
        try {
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_android_background)) {
                this.f4586a = typedArray.getResourceId(g.j.ViewBackgroundHelper_android_background, -1);
                r rVar = (r) this.f4588c;
                Context context = view.getContext();
                int i10 = this.f4586a;
                synchronized (rVar) {
                    colorStateListI = rVar.f9337a.i(context, i10);
                }
                if (colorStateListI != null) {
                    H(colorStateListI);
                }
            }
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_backgroundTint)) {
                d0.i(view, aVarF.r(g.j.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_backgroundTintMode)) {
                d0.j(view, n1.c(typedArray.getInt(g.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            aVarF.G();
        } catch (Throwable th) {
            aVarF.G();
            throw th;
        }
    }

    public k(View view) {
        this.f4586a = -1;
        this.f4587b = view;
        this.f4588c = r.a();
    }

    public k(s sVar) {
        this.f4587b = sVar;
        this.f4588c = new ArrayDeque();
        this.f4589d = new ArrayDeque();
        this.f4590e = new PriorityQueue();
        this.f4586a = -1;
    }

    public k(x xVar) {
        this.f4587b = new s0.d(30);
        this.f4588c = new ArrayList();
        this.f4589d = new ArrayList();
        this.f4586a = 0;
        this.f4590e = xVar;
        this.f = new kf.i(20, this);
    }

    public k(Object obj, Looper looper, Looper looper2, v vVar, z zVar) {
        this.f4587b = vVar.a(looper, null);
        this.f4588c = vVar.a(looper2, null);
        this.f4590e = obj;
        this.f = obj;
        this.f4589d = zVar;
    }
}
