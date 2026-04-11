package nb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import qb.c2;
import qb.o0;
import qb.p0;
import qb.q0;
import qb.r0;
import qb.t0;
import qb.u0;
import qb.v0;
import qb.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f8946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f8947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Thread f8948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d8.j f8949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l f8950e;

    public j(l lVar, long j4, Throwable th, Thread thread, d8.j jVar) {
        this.f8950e = lVar;
        this.f8946a = j4;
        this.f8947b = th;
        this.f8948c = thread;
        this.f8949d = jVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it;
        long j4 = this.f8946a;
        long j7 = j4 / 1000;
        l lVar = this.f8950e;
        NavigableSet navigableSetC = ((tb.a) lVar.f8965m.f2036c).c();
        Boolean bool = null;
        String str = !navigableSetC.isEmpty() ? (String) navigableSetC.first() : null;
        String str2 = "FirebaseCrashlytics";
        if (str == null) {
            Log.e("FirebaseCrashlytics", "Tried to write a fatal exception while no session was open.", null);
            return vf.g.A(null);
        }
        lVar.f8957c.b();
        c2.o oVar = lVar.f8965m;
        oVar.getClass();
        String strConcat = "Persisting fatal event for session ".concat(str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strConcat, null);
        }
        q qVar = (q) oVar.f2035b;
        Context context = qVar.f8992a;
        int i = context.getResources().getConfiguration().orientation;
        vb.b bVar = qVar.f8995d;
        Stack stack = new Stack();
        for (Throwable cause = this.f8947b; cause != null; cause = cause.getCause()) {
            stack.push(cause);
        }
        nc.p pVar = null;
        while (!stack.isEmpty()) {
            Throwable th = (Throwable) stack.pop();
            pVar = new nc.p(th.getLocalizedMessage(), th.getClass().getName(), bVar.o(th.getStackTrace()), pVar);
            stack = stack;
            i = i;
            bool = bool;
            str2 = str2;
        }
        String str3 = str2;
        Boolean bool2 = bool;
        int i10 = i;
        o0 o0Var = new o0();
        o0Var.f10684b = "crash";
        o0Var.f10683a = j7;
        o0Var.f10688g = (byte) (o0Var.f10688g | 1);
        c2 c2VarD = kb.c.f7397b.d(context);
        int i11 = ((z0) c2VarD).f10783c;
        Boolean boolValueOf = i11 > 0 ? Boolean.valueOf(i11 != 100) : bool2;
        ArrayList arrayListC = kb.c.c(context);
        byte b8 = (byte) 1;
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pVar.f9071c;
        Thread thread = this.f8948c;
        String name = thread.getName();
        if (name == null) {
            throw new NullPointerException("Null name");
        }
        byte b10 = (byte) 1;
        List listD = q.d(stackTraceElementArr, 4);
        if (listD == null) {
            throw new NullPointerException("Null frames");
        }
        String str4 = str;
        if (b10 != 1) {
            StringBuilder sb = new StringBuilder();
            if (b10 == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
        }
        arrayList.add(new v0(name, 4, listD));
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = Thread.getAllStackTraces().entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it2.next();
            Thread key = next.getKey();
            if (key.equals(thread)) {
                it = it2;
            } else {
                StackTraceElement[] stackTraceElementArrO = bVar.o(next.getValue());
                String name2 = key.getName();
                if (name2 == null) {
                    throw new NullPointerException("Null name");
                }
                List listD2 = q.d(stackTraceElementArrO, 0);
                if (listD2 == null) {
                    throw new NullPointerException("Null frames");
                }
                if (b10 != 1) {
                    StringBuilder sb2 = new StringBuilder();
                    if (b10 == 0) {
                        sb2.append(" importance");
                    }
                    throw new IllegalStateException(l0.e.l("Missing required properties:", sb2));
                }
                it = it2;
                arrayList.add(new v0(name2, 0, listD2));
            }
            it2 = it;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        t0 t0VarC = q.c(pVar, 0);
        u0 u0VarE = q.e();
        List listA = qVar.a();
        if (listA == null) {
            throw new NullPointerException("Null binaries");
        }
        r0 r0Var = new r0(listUnmodifiableList, t0VarC, null, u0VarE, listA);
        if (b8 != 1) {
            StringBuilder sb3 = new StringBuilder();
            if (b8 == 0) {
                sb3.append(" uiOrientation");
            }
            throw new IllegalStateException(l0.e.l("Missing required properties:", sb3));
        }
        o0Var.f10685c = new q0(r0Var, null, null, boolValueOf, c2VarD, arrayListC, i10);
        o0Var.f10686d = qVar.b(i10);
        p0 p0VarA = o0Var.a();
        pb.e eVar = (pb.e) oVar.f2038e;
        tb.c cVar = (tb.c) oVar.f;
        ((tb.a) oVar.f2036c).d(c2.o.d(c2.o.c(p0VarA, eVar, cVar, sd.q.f11670v), cVar), str4, true);
        try {
            tb.c cVar2 = lVar.f8960g;
            String str5 = ".ae" + j4;
            cVar2.getClass();
            if (!new File((File) cVar2.f11985x, str5).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e9) {
            Log.w(str3, "Could not create app exception marker file.", e9);
        }
        d8.j jVar = this.f8949d;
        lVar.b(false, jVar, false);
        lVar.c(new d().f8933a, Boolean.FALSE);
        if (!lVar.f8956b.a()) {
            return vf.g.A(bool2);
        }
        j9.p pVar2 = ((j9.i) ((AtomicReference) jVar.i).get()).f6688a;
        ob.b bVar2 = lVar.f8959e.f9742a;
        m2.e eVar2 = new m2.e();
        eVar2.f8050v = this;
        return pVar2.k(bVar2, eVar2);
    }
}
