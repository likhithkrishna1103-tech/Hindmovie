package z6;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends Exception {
    public static final StackTraceElement[] A = new StackTraceElement[0];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f15324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public x6.e f15325w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15326x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Class f15327y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f15328z;

    public x(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (th instanceof x) {
            Iterator it = ((x) th).f15324v.iterator();
            while (it.hasNext()) {
                a((Throwable) it.next(), arrayList);
            }
        } else if (th != null) {
            arrayList.add(th);
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
            StringBuilder sb = new StringBuilder("Root cause (");
            int i10 = i + 1;
            sb.append(i10);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i));
            i = i10;
        }
    }

    public final void e(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.f15324v, new w(appendable));
        } catch (IOException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f15328z);
        String str2 = "";
        if (this.f15327y != null) {
            str = ", " + this.f15327y;
        } else {
            str = "";
        }
        sb.append(str);
        int i = this.f15326x;
        sb.append(i != 0 ? ", ".concat(l0.e.v(i)) : "");
        if (this.f15325w != null) {
            str2 = ", " + this.f15325w;
        }
        sb.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Throwable th = (Throwable) obj;
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        e(System.err);
    }

    public x(String str, List list) {
        this.f15328z = str;
        setStackTrace(A);
        this.f15324v = list;
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
