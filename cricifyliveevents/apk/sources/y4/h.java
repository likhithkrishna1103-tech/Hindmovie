package y4;

import f9.i1;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c5.a, xe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.a f14853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final xe.a f14854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public vd.h f14855x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Throwable f14856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i1 f14857z;

    public h(c5.a aVar) {
        xe.c cVarA = xe.d.a();
        ge.i.e(aVar, "delegate");
        this.f14853v = aVar;
        this.f14854w = cVarA;
        this.f14857z = new i1(this);
    }

    @Override // xe.a
    public final void a(Object obj) {
        this.f14854w.a(null);
    }

    @Override // c5.a
    public final boolean c() {
        return this.f14853v.c();
    }

    @Override // c5.a
    public final c5.c c0(String str) {
        ge.i.e(str, "sql");
        i1 i1Var = this.f14857z;
        if (i1Var == null) {
            return this.f14853v.c0(str);
        }
        Object objH = i1Var.h(str);
        ge.i.b(objH);
        return new g((c5.c) objH);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        i1 i1Var = this.f14857z;
        if (i1Var != null) {
            i1Var.n(-1);
        }
        this.f14853v.close();
    }

    @Override // xe.a
    public final Object g(xd.c cVar) {
        return this.f14854w.g(cVar);
    }

    public final void q(StringBuilder sb) {
        List listX;
        Iterable iterableX;
        int i;
        if (this.f14855x == null && this.f14856y == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append('\n');
        } else {
            sb.append("\t\tStatus: Acquired connection");
            sb.append('\n');
            vd.h hVar = this.f14855x;
            if (hVar != null) {
                sb.append("\t\tCoroutine: " + hVar);
                sb.append('\n');
            }
            Throwable th = this.f14856y;
            if (th != null) {
                sb.append("\t\tAcquired:");
                sb.append('\n');
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                String string = stringWriter.toString();
                ge.i.d(string, "toString(...)");
                ne.c cVar = new ne.c(string);
                if (cVar.hasNext()) {
                    Object next = cVar.next();
                    if (cVar.hasNext()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        while (cVar.hasNext()) {
                            arrayList.add(cVar.next());
                        }
                        listX = arrayList;
                    } else {
                        listX = n5.a.x(next);
                    }
                } else {
                    listX = sd.p.f11669v;
                }
                int size = listX.size() - 1;
                if (size <= 0) {
                    iterableX = sd.p.f11669v;
                } else if (size == 1) {
                    iterableX = n5.a.x(sd.j.m0(listX));
                } else {
                    ArrayList arrayList2 = new ArrayList(size);
                    if (listX instanceof RandomAccess) {
                        int size2 = listX.size();
                        for (int i10 = 1; i10 < size2; i10++) {
                            arrayList2.add(listX.get(i10));
                        }
                    } else {
                        ListIterator listIterator = listX.listIterator(1);
                        while (listIterator.hasNext()) {
                            arrayList2.add(listIterator.next());
                        }
                    }
                    iterableX = arrayList2;
                }
                Iterator it = iterableX.iterator();
                while (it.hasNext()) {
                    sb.append("\t\t" + ((String) it.next()));
                    sb.append('\n');
                }
            }
        }
        if (this.f14857z != null) {
            StringBuilder sb2 = new StringBuilder("\t\tPrepared Statement Cache Size: ");
            i1 i1Var = this.f14857z;
            synchronized (((f9.z) i1Var.f12539g)) {
                i = i1Var.f12536c;
            }
            sb2.append(i);
            sb.append(sb2.toString());
            sb.append('\n');
        }
    }

    public final String toString() {
        return this.f14853v.toString();
    }
}
