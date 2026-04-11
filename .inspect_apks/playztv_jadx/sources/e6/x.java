package e6;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends Exception {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final StackTraceElement[] f4573z = new StackTraceElement[0];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f4574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c6.f f4575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4576w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Class f4577x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f4578y;

    public x(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof x)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((x) th).f4574u.iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), arrayList);
        }
    }

    public static void b(List list, w wVar) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            wVar.append("Cause (");
            int i10 = i + 1;
            wVar.append(String.valueOf(i10));
            wVar.append(" of ");
            wVar.append(String.valueOf(size));
            wVar.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof x) {
                ((x) th).e(wVar);
            } else {
                c(th, wVar);
            }
            i = i10;
        }
    }

    public static void c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb2 = new StringBuilder("Root cause (");
            int i10 = i + 1;
            sb2.append(i10);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i("Glide", sb2.toString(), (Throwable) arrayList.get(i));
            i = i10;
        }
    }

    public final void e(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.f4574u, new w(appendable));
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.f4578y);
        String str2 = "";
        if (this.f4577x != null) {
            str = ", " + this.f4577x;
        } else {
            str = "";
        }
        sb2.append(str);
        int i = this.f4576w;
        sb2.append(i != 0 ? ", ".concat(l4.a.z(i)) : "");
        if (this.f4575v != null) {
            str2 = ", " + this.f4575v;
        }
        sb2.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb2.toString();
        }
        if (arrayList.size() == 1) {
            sb2.append("\nThere was 1 root cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(arrayList.size());
            sb2.append(" root causes:");
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Throwable th = (Throwable) obj;
            sb2.append('\n');
            sb2.append(th.getClass().getName());
            sb2.append('(');
            sb2.append(th.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        e(System.err);
    }

    public x(String str, List list) {
        this.f4578y = str;
        setStackTrace(f4573z);
        this.f4574u = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        e(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        e(printWriter);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
