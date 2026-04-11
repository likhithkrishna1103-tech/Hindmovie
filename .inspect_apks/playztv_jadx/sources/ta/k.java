package ta;

import android.content.Context;
import android.util.Log;
import h4.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import wa.c2;
import wa.o0;
import wa.p0;
import wa.q0;
import wa.r0;
import wa.t0;
import wa.t1;
import wa.u0;
import wa.v0;
import wa.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f12373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f12374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Thread f12375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b7.s f12376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f12377e;

    public k(m mVar, long j5, Throwable th, Thread thread, b7.s sVar) {
        this.f12377e = mVar;
        this.f12373a = j5;
        this.f12374b = th;
        this.f12375c = thread;
        this.f12376d = sVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        Thread thread;
        long j5 = this.f12373a;
        long j8 = j5 / 1000;
        m mVar = this.f12377e;
        NavigableSet navigableSetC = ((za.a) mVar.f12391m.f1738c).c();
        String str = !navigableSetC.isEmpty() ? (String) navigableSetC.first() : null;
        if (str == null) {
            Log.e("FirebaseCrashlytics", "Tried to write a fatal exception while no session was open.", null);
            return t1.k(null);
        }
        mVar.f12383c.g();
        b2.g gVar = mVar.f12391m;
        gVar.getClass();
        String strConcat = "Persisting fatal event for session ".concat(str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strConcat, null);
        }
        r rVar = (r) gVar.f1737b;
        Context context = rVar.f12418a;
        int i = context.getResources().getConfiguration().orientation;
        z zVar = rVar.f12421d;
        Stack stack = new Stack();
        for (Throwable cause = this.f12374b; cause != null; cause = cause.getCause()) {
            stack.push(cause);
        }
        ub.o oVar = null;
        while (!stack.isEmpty()) {
            Throwable th = (Throwable) stack.pop();
            oVar = new ub.o(th.getLocalizedMessage(), th.getClass().getName(), zVar.y(th.getStackTrace()), oVar, 6);
        }
        ub.o oVar2 = oVar;
        o0 o0Var = new o0();
        o0Var.f13981b = "crash";
        o0Var.f13980a = j8;
        o0Var.f13985g = (byte) (o0Var.f13985g | 1);
        c2 c2VarD = qa.c.f11168b.d(context);
        int i10 = ((z0) c2VarD).f14080c;
        Boolean boolValueOf = i10 > 0 ? Boolean.valueOf(i10 != 100) : null;
        ArrayList arrayListC = qa.c.c(context);
        byte b10 = (byte) 1;
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) oVar2.f12870x;
        Thread thread2 = this.f12375c;
        String name = thread2.getName();
        if (name == null) {
            throw new NullPointerException("Null name");
        }
        byte b11 = (byte) 1;
        List listD = r.d(stackTraceElementArr, 4);
        if (listD == null) {
            throw new NullPointerException("Null frames");
        }
        if (b11 != 1) {
            StringBuilder sb2 = new StringBuilder();
            if (b11 == 0) {
                sb2.append(" importance");
            }
            throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
        }
        String str2 = str;
        arrayList.add(new v0(name, 4, listD));
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            if (key.equals(thread2)) {
                thread = thread2;
            } else {
                StackTraceElement[] stackTraceElementArrY = zVar.y(entry.getValue());
                String name2 = key.getName();
                if (name2 == null) {
                    throw new NullPointerException("Null name");
                }
                List listD2 = r.d(stackTraceElementArrY, 0);
                if (listD2 == null) {
                    throw new NullPointerException("Null frames");
                }
                if (b11 != 1) {
                    StringBuilder sb3 = new StringBuilder();
                    if (b11 == 0) {
                        sb3.append(" importance");
                    }
                    throw new IllegalStateException(e6.j.o("Missing required properties:", sb3));
                }
                thread = thread2;
                arrayList.add(new v0(name2, 0, listD2));
            }
            thread2 = thread;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        t0 t0VarC = r.c(oVar2, 0);
        u0 u0VarE = r.e();
        List listA = rVar.a();
        if (listA == null) {
            throw new NullPointerException("Null binaries");
        }
        r0 r0Var = new r0(listUnmodifiableList, t0VarC, null, u0VarE, listA);
        if (b10 != 1) {
            StringBuilder sb4 = new StringBuilder();
            if (b10 == 0) {
                sb4.append(" uiOrientation");
            }
            throw new IllegalStateException(e6.j.o("Missing required properties:", sb4));
        }
        o0Var.f13982c = new q0(r0Var, null, null, boolValueOf, c2VarD, arrayListC, i);
        o0Var.f13983d = rVar.b(i);
        p0 p0VarA = o0Var.a();
        va.f fVar = (va.f) gVar.f1740e;
        za.c cVar = (za.c) gVar.f;
        ((za.a) gVar.f1738c).d(b2.g.d(b2.g.c(p0VarA, fVar, cVar), cVar), str2, true);
        try {
            za.c cVar2 = mVar.f12386g;
            String str3 = ".ae" + j5;
            cVar2.getClass();
            if (!new File((File) cVar2.f14936c, str3).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e10) {
            Log.w("FirebaseCrashlytics", "Could not create app exception marker file.", e10);
        }
        b7.s sVar = this.f12376d;
        mVar.b(false, sVar, false);
        mVar.c(new d().f12359a, Boolean.FALSE);
        return !mVar.f12382b.a() ? t1.k(null) : ((o8.h) ((AtomicReference) sVar.i).get()).f9421a.k(mVar.f12385e.f12823a, new o4.c(this, str2));
    }
}
