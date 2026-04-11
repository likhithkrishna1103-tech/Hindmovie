package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f8478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f8479e;
    public Object f;

    public p(ue.a aVar, o4.c cVar, ye.h hVar) {
        List listJ;
        be.h.e(cVar, "routeDatabase");
        this.f8476b = aVar;
        this.f8477c = cVar;
        od.q qVar = od.q.f9570u;
        this.f8478d = qVar;
        this.f8479e = qVar;
        this.f = new ArrayList();
        ue.o oVar = aVar.f12929h;
        be.h.e(oVar, "url");
        URI uriG = oVar.g();
        if (uriG.getHost() == null) {
            listJ = ve.b.j(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = aVar.f12928g.select(uriG);
            List<Proxy> list = listSelect;
            if (list == null || list.isEmpty()) {
                listJ = ve.b.j(Proxy.NO_PROXY);
            } else {
                be.h.d(listSelect, "proxiesOrNull");
                listJ = ve.b.v(listSelect);
            }
        }
        this.f8478d = listJ;
        this.f8475a = 0;
    }

    public int A(int i, int i10) {
        int i11;
        int i12;
        p0.d dVar = (p0.d) this.f8476b;
        ArrayList arrayList = (ArrayList) this.f8478d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            q4.a aVar = (q4.a) arrayList.get(size);
            int i13 = aVar.f10737a;
            if (i13 == 8) {
                int i14 = aVar.f10738b;
                int i15 = aVar.f10740d;
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
                            aVar.f10738b = i14 + 1;
                            aVar.f10740d = i15 + 1;
                        } else if (i10 == 2) {
                            aVar.f10738b = i14 - 1;
                            aVar.f10740d = i15 - 1;
                        }
                    }
                } else if (i12 == i14) {
                    if (i10 == 1) {
                        aVar.f10740d = i15 + 1;
                    } else if (i10 == 2) {
                        aVar.f10740d = i15 - 1;
                    }
                    i++;
                } else {
                    if (i10 == 1) {
                        aVar.f10738b = i14 + 1;
                    } else if (i10 == 2) {
                        aVar.f10738b = i14 - 1;
                    }
                    i--;
                }
            } else {
                int i16 = aVar.f10738b;
                if (i16 <= i) {
                    if (i13 == 1) {
                        i -= aVar.f10740d;
                    } else if (i13 == 2) {
                        i += aVar.f10740d;
                    }
                } else if (i10 == 1) {
                    aVar.f10738b = i16 + 1;
                } else if (i10 == 2) {
                    aVar.f10738b = i16 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            q4.a aVar2 = (q4.a) arrayList.get(size2);
            if (aVar2.f10737a == 8) {
                int i17 = aVar2.f10740d;
                if (i17 == aVar2.f10738b || i17 < 0) {
                    arrayList.remove(size2);
                    aVar2.f10739c = null;
                    dVar.b(aVar2);
                }
            } else if (aVar2.f10740d <= 0) {
                arrayList.remove(size2);
                aVar2.f10739c = null;
                dVar.b(aVar2);
            }
        }
        return i;
    }

    public void B(Object obj) {
        Object obj2 = this.f8479e;
        this.f8479e = obj;
        if (obj2.equals(obj)) {
            return;
        }
        a2.o0 o0Var = ((a2.e0) this.f8478d).f192v;
        ((Integer) obj2).getClass();
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        o0Var.S1();
        o0Var.J1(1, 10, num);
        o0Var.J1(2, 10, num);
        o0Var.H.e(21, new a2.c0(iIntValue, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r9 < r2.f12064v) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r9, s1.u r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f8478d
            java.util.ArrayDeque r0 = (java.util.ArrayDeque) r0
            java.lang.Object r1 = r8.f8479e
            java.util.PriorityQueue r1 = (java.util.PriorityQueue) r1
            int r2 = r8.f8475a
            if (r2 == 0) goto L9e
            r3 = -1
            if (r2 == r3) goto L27
            int r2 = r1.size()
            int r4 = r8.f8475a
            if (r2 < r4) goto L27
            java.lang.Object r2 = r1.peek()
            t1.s r2 = (t1.s) r2
            int r4 = s1.b0.f11647a
            long r4 = r2.f12064v
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 >= 0) goto L27
            goto L9e
        L27:
            java.lang.Object r2 = r8.f8477c
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L37
            s1.u r2 = new s1.u
            r2.<init>()
            goto L3d
        L37:
            java.lang.Object r2 = r2.pop()
            s1.u r2 = (s1.u) r2
        L3d:
            int r4 = r11.a()
            r2.G(r4)
            byte[] r4 = r11.f11709a
            int r11 = r11.f11710b
            byte[] r5 = r2.f11709a
            int r6 = r2.a()
            r7 = 0
            java.lang.System.arraycopy(r4, r11, r5, r7, r6)
            java.lang.Object r11 = r8.f
            t1.s r11 = (t1.s) r11
            if (r11 == 0) goto L64
            long r4 = r11.f12064v
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 != 0) goto L64
            java.util.ArrayList r9 = r11.f12063u
            r9.add(r2)
            return
        L64:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L70
            t1.s r11 = new t1.s
            r11.<init>()
            goto L76
        L70:
            java.lang.Object r11 = r0.pop()
            t1.s r11 = (t1.s) r11
        L76:
            java.util.ArrayList r0 = r11.f12063u
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 == 0) goto L82
            r7 = 1
        L82:
            s1.d.b(r7)
            boolean r4 = r0.isEmpty()
            s1.d.g(r4)
            r11.f12064v = r9
            r0.add(r2)
            r1.add(r11)
            r8.f = r11
            int r9 = r8.f8475a
            if (r9 == r3) goto L9d
            r8.i(r9)
        L9d:
            return
        L9e:
            java.lang.Object r0 = r8.f8476b
            t1.t r0 = (t1.t) r0
            r0.i(r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n.p.a(long, s1.u):void");
    }

    public void b() {
        View view = (View) this.f8476b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((d3) this.f8478d) != null) {
                if (((d3) this.f) == null) {
                    this.f = new d3();
                }
                d3 d3Var = (d3) this.f;
                d3Var.f8375c = null;
                d3Var.f8374b = false;
                d3Var.f8376d = null;
                d3Var.f8373a = false;
                WeakHashMap weakHashMap = q0.o0.f10475a;
                ColorStateList colorStateListC = q0.f0.c(view);
                if (colorStateListC != null) {
                    d3Var.f8374b = true;
                    d3Var.f8375c = colorStateListC;
                }
                PorterDuff.Mode modeD = q0.f0.d(view);
                if (modeD != null) {
                    d3Var.f8373a = true;
                    d3Var.f8376d = modeD;
                }
                if (d3Var.f8374b || d3Var.f8373a) {
                    t.e(background, d3Var, view.getDrawableState());
                    return;
                }
            }
            d3 d3Var2 = (d3) this.f8479e;
            if (d3Var2 != null) {
                t.e(background, d3Var2, view.getDrawableState());
                return;
            }
            d3 d3Var3 = (d3) this.f8478d;
            if (d3Var3 != null) {
                t.e(background, d3Var3, view.getDrawableState());
            }
        }
    }

    public boolean c(int i) {
        ArrayList arrayList = (ArrayList) this.f8478d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            q4.a aVar = (q4.a) arrayList.get(i10);
            int i11 = aVar.f10737a;
            if (i11 != 8) {
                if (i11 == 1) {
                    int i12 = aVar.f10738b;
                    int i13 = aVar.f10740d + i12;
                    while (i12 < i13) {
                        if (h(i12, i10 + 1) == i) {
                            return true;
                        }
                        i12++;
                    }
                } else {
                    continue;
                }
            } else {
                if (h(aVar.f10740d, i10 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        ArrayList arrayList = (ArrayList) this.f8478d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((a1) this.f8479e).r((q4.a) arrayList.get(i));
        }
        u(arrayList);
        this.f8475a = 0;
    }

    public void e() {
        a1 a1Var = (a1) this.f8479e;
        d();
        ArrayList arrayList = (ArrayList) this.f8477c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            q4.a aVar = (q4.a) arrayList.get(i);
            int i10 = aVar.f10737a;
            if (i10 == 1) {
                a1Var.r(aVar);
                a1Var.y(aVar.f10738b, aVar.f10740d);
            } else if (i10 == 2) {
                a1Var.r(aVar);
                int i11 = aVar.f10738b;
                int i12 = aVar.f10740d;
                RecyclerView recyclerView = (RecyclerView) a1Var.f8343u;
                recyclerView.S(i11, i12, true);
                recyclerView.D0 = true;
                recyclerView.A0.f10937c += i12;
            } else if (i10 == 4) {
                a1Var.r(aVar);
                a1Var.w(aVar.f10738b, aVar.f10740d, aVar.f10739c);
            } else if (i10 == 8) {
                a1Var.r(aVar);
                a1Var.z(aVar.f10738b, aVar.f10740d);
            }
        }
        u(arrayList);
        this.f8475a = 0;
    }

    public void f(q4.a aVar) {
        int i;
        p0.d dVar = (p0.d) this.f8476b;
        int i10 = aVar.f10737a;
        if (i10 == 1 || i10 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iA = A(aVar.f10738b, i10);
        int i11 = aVar.f10738b;
        int i12 = aVar.f10737a;
        if (i12 == 2) {
            i = 0;
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aVar);
            }
            i = 1;
        }
        int i13 = 1;
        for (int i14 = 1; i14 < aVar.f10740d; i14++) {
            int iA2 = A((i * i14) + aVar.f10738b, aVar.f10737a);
            int i15 = aVar.f10737a;
            if (i15 == 2 ? iA2 != iA : !(i15 == 4 && iA2 == iA + 1)) {
                q4.a aVarP = p(aVar.f10739c, i15, iA, i13);
                g(aVarP, i11);
                aVarP.f10739c = null;
                dVar.b(aVarP);
                if (aVar.f10737a == 4) {
                    i11 += i13;
                }
                i13 = 1;
                iA = iA2;
            } else {
                i13++;
            }
        }
        Object obj = aVar.f10739c;
        aVar.f10739c = null;
        dVar.b(aVar);
        if (i13 > 0) {
            q4.a aVarP2 = p(obj, aVar.f10737a, iA, i13);
            g(aVarP2, i11);
            aVarP2.f10739c = null;
            dVar.b(aVarP2);
        }
    }

    public void g(q4.a aVar, int i) {
        a1 a1Var = (a1) this.f8479e;
        a1Var.r(aVar);
        int i10 = aVar.f10737a;
        if (i10 != 2) {
            if (i10 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            a1Var.w(i, aVar.f10740d, aVar.f10739c);
        } else {
            int i11 = aVar.f10740d;
            RecyclerView recyclerView = (RecyclerView) a1Var.f8343u;
            recyclerView.S(i, i11, true);
            recyclerView.D0 = true;
            recyclerView.A0.f10937c += i11;
        }
    }

    public int h(int i, int i10) {
        ArrayList arrayList = (ArrayList) this.f8478d;
        int size = arrayList.size();
        while (i10 < size) {
            q4.a aVar = (q4.a) arrayList.get(i10);
            int i11 = aVar.f10737a;
            if (i11 == 8) {
                int i12 = aVar.f10738b;
                if (i12 == i) {
                    i = aVar.f10740d;
                } else {
                    if (i12 < i) {
                        i--;
                    }
                    if (aVar.f10740d <= i) {
                        i++;
                    }
                }
            } else {
                int i13 = aVar.f10738b;
                if (i13 > i) {
                    continue;
                } else if (i11 == 2) {
                    int i14 = aVar.f10740d;
                    if (i < i13 + i14) {
                        return -1;
                    }
                    i -= i14;
                } else if (i11 == 1) {
                    i += aVar.f10740d;
                }
            }
            i10++;
        }
        return i;
    }

    public void i(int i) {
        ArrayList arrayList;
        PriorityQueue priorityQueue = (PriorityQueue) this.f8479e;
        while (priorityQueue.size() > i) {
            t1.s sVar = (t1.s) priorityQueue.poll();
            int i10 = s1.b0.f11647a;
            int i11 = 0;
            while (true) {
                arrayList = sVar.f12063u;
                if (i11 >= arrayList.size()) {
                    break;
                }
                ((t1.t) this.f8476b).i(sVar.f12064v, (s1.u) arrayList.get(i11));
                ((ArrayDeque) this.f8477c).push((s1.u) arrayList.get(i11));
                i11++;
            }
            arrayList.clear();
            t1.s sVar2 = (t1.s) this.f;
            if (sVar2 != null && sVar2.f12064v == sVar.f12064v) {
                this.f = null;
            }
            ((ArrayDeque) this.f8478d).push(sVar);
        }
    }

    public ColorStateList j() {
        d3 d3Var = (d3) this.f8479e;
        if (d3Var != null) {
            return (ColorStateList) d3Var.f8375c;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        d3 d3Var = (d3) this.f8479e;
        if (d3Var != null) {
            return (PorterDuff.Mode) d3Var.f8376d;
        }
        return null;
    }

    public boolean l() {
        return this.f8475a < ((List) this.f8478d).size() || !((ArrayList) this.f).isEmpty();
    }

    public boolean m() {
        return ((ArrayList) this.f8477c).size() > 0;
    }

    public void n(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListI;
        View view = (View) this.f8476b;
        kc.b bVarD = kc.b.D(view.getContext(), attributeSet, g.j.ViewBackgroundHelper, i);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        View view2 = (View) this.f8476b;
        q0.o0.m(view2, view2.getContext(), g.j.ViewBackgroundHelper, attributeSet, (TypedArray) bVarD.f7621w, i);
        try {
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_android_background)) {
                this.f8475a = typedArray.getResourceId(g.j.ViewBackgroundHelper_android_background, -1);
                t tVar = (t) this.f8477c;
                Context context = view.getContext();
                int i10 = this.f8475a;
                synchronized (tVar) {
                    colorStateListI = tVar.f8534a.i(context, i10);
                }
                if (colorStateListI != null) {
                    w(colorStateListI);
                }
            }
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_backgroundTint)) {
                q0.f0.i(view, bVarD.q(g.j.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArray.hasValue(g.j.ViewBackgroundHelper_backgroundTintMode)) {
                q0.f0.j(view, n1.b(typedArray.getInt(g.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            bVarD.E();
        } catch (Throwable th) {
            bVarD.E();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object, java.util.List] */
    public va.o o() throws SocketException, UnknownHostException {
        String hostAddress;
        int port;
        List listG;
        boolean zContains;
        if (!l()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f8475a < ((List) this.f8478d).size()) {
            ue.a aVar = (ue.a) this.f8476b;
            if (this.f8475a >= ((List) this.f8478d).size()) {
                throw new SocketException("No route to " + aVar.f12929h.f13011d + "; exhausted proxy configurations: " + ((List) this.f8478d));
            }
            List list = (List) this.f8478d;
            int i = this.f8475a;
            this.f8475a = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            ArrayList arrayList2 = new ArrayList();
            this.f8479e = arrayList2;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                ue.o oVar = aVar.f12929h;
                hostAddress = oVar.f13011d;
                port = oVar.f13012e;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                if (address == null) {
                    hostAddress = inetSocketAddress.getHostName();
                    be.h.d(hostAddress, "hostName");
                } else {
                    hostAddress = address.getHostAddress();
                    be.h.d(hostAddress, "address.hostAddress");
                }
                port = inetSocketAddress.getPort();
            }
            if (1 > port || port >= 65536) {
                throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList2.add(InetSocketAddress.createUnresolved(hostAddress, port));
            } else {
                byte[] bArr = ve.b.f13497a;
                be.h.e(hostAddress, "<this>");
                ie.d dVar = ve.b.f;
                dVar.getClass();
                if (dVar.f6612u.matcher(hostAddress).matches()) {
                    listG = android.support.v4.media.session.b.G(InetAddress.getByName(hostAddress));
                } else {
                    aVar.f12923a.getClass();
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                        be.h.d(allByName, "getAllByName(hostname)");
                        List listY = od.h.Y(allByName);
                        if (listY.isEmpty()) {
                            throw new UnknownHostException(aVar.f12923a + " returned no addresses for " + hostAddress);
                        }
                        listG = listY;
                    } catch (NullPointerException e10) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                        unknownHostException.initCause(e10);
                        throw unknownHostException;
                    }
                }
                Iterator it = listG.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new InetSocketAddress((InetAddress) it.next(), port));
                }
            }
            Iterator it2 = this.f8479e.iterator();
            while (it2.hasNext()) {
                ue.a0 a0Var = new ue.a0((ue.a) this.f8476b, proxy, (InetSocketAddress) it2.next());
                o4.c cVar = (o4.c) this.f8477c;
                synchronized (cVar) {
                    zContains = ((LinkedHashSet) cVar.f9349u).contains(a0Var);
                }
                if (zContains) {
                    ((ArrayList) this.f).add(a0Var);
                } else {
                    arrayList.add(a0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            od.o.V(arrayList, (ArrayList) this.f);
            ((ArrayList) this.f).clear();
        }
        return new va.o(arrayList);
    }

    public q4.a p(Object obj, int i, int i10, int i11) {
        q4.a aVar = (q4.a) ((p0.d) this.f8476b).i();
        if (aVar != null) {
            aVar.f10737a = i;
            aVar.f10738b = i10;
            aVar.f10740d = i11;
            aVar.f10739c = obj;
            return aVar;
        }
        q4.a aVar2 = new q4.a();
        aVar2.f10737a = i;
        aVar2.f10738b = i10;
        aVar2.f10740d = i11;
        aVar2.f10739c = obj;
        return aVar2;
    }

    public void q() {
        this.f8475a = -1;
        w(null);
        b();
    }

    public void r(int i) {
        ColorStateList colorStateListI;
        this.f8475a = i;
        t tVar = (t) this.f8477c;
        if (tVar != null) {
            Context context = ((View) this.f8476b).getContext();
            synchronized (tVar) {
                colorStateListI = tVar.f8534a.i(context, i);
            }
        } else {
            colorStateListI = null;
        }
        w(colorStateListI);
        b();
    }

    public void s(q4.a aVar) {
        a1 a1Var = (a1) this.f8479e;
        ((ArrayList) this.f8478d).add(aVar);
        int i = aVar.f10737a;
        if (i == 1) {
            a1Var.y(aVar.f10738b, aVar.f10740d);
            return;
        }
        if (i == 2) {
            int i10 = aVar.f10738b;
            int i11 = aVar.f10740d;
            RecyclerView recyclerView = (RecyclerView) a1Var.f8343u;
            recyclerView.S(i10, i11, false);
            recyclerView.D0 = true;
            return;
        }
        if (i == 4) {
            a1Var.w(aVar.f10738b, aVar.f10740d, aVar.f10739c);
        } else if (i == 8) {
            a1Var.z(aVar.f10738b, aVar.f10740d);
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
    public void t() {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.p.t():void");
    }

    public void u(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            q4.a aVar = (q4.a) arrayList.get(i);
            aVar.f10739c = null;
            ((p0.d) this.f8476b).b(aVar);
        }
        arrayList.clear();
    }

    public void v(Runnable runnable) {
        s1.y yVar = (s1.y) this.f8476b;
        if (yVar.f11718a.getLooper().getThread().isAlive()) {
            yVar.c(runnable);
        }
    }

    public void w(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((d3) this.f8478d) == null) {
                this.f8478d = new d3();
            }
            d3 d3Var = (d3) this.f8478d;
            d3Var.f8375c = colorStateList;
            d3Var.f8374b = true;
        } else {
            this.f8478d = null;
        }
        b();
    }

    public void x(int i) {
        s1.d.g(i >= 0);
        this.f8475a = i;
        i(i);
    }

    public void y(ColorStateList colorStateList) {
        if (((d3) this.f8479e) == null) {
            this.f8479e = new d3();
        }
        d3 d3Var = (d3) this.f8479e;
        d3Var.f8375c = colorStateList;
        d3Var.f8374b = true;
        b();
    }

    public void z(PorterDuff.Mode mode) {
        if (((d3) this.f8479e) == null) {
            this.f8479e = new d3();
        }
        d3 d3Var = (d3) this.f8479e;
        d3Var.f8376d = mode;
        d3Var.f8373a = true;
        b();
    }

    public p(View view) {
        this.f8475a = -1;
        this.f8476b = view;
        this.f8477c = t.a();
    }

    public p(t1.t tVar) {
        this.f8476b = tVar;
        this.f8477c = new ArrayDeque();
        this.f8478d = new ArrayDeque();
        this.f8479e = new PriorityQueue();
        this.f8475a = -1;
    }

    public p(a1 a1Var) {
        this.f8476b = new p0.d(30);
        this.f8477c = new ArrayList();
        this.f8478d = new ArrayList();
        this.f8475a = 0;
        this.f8479e = a1Var;
        this.f = new a1(this);
    }

    public p(Object obj, Looper looper, Looper looper2, s1.w wVar, a2.e0 e0Var) {
        this.f8476b = wVar.a(looper, null);
        this.f8477c = wVar.a(looper2, null);
        this.f8479e = obj;
        this.f = obj;
        this.f8478d = e0Var;
    }
}
