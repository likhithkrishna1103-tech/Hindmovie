package cf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2745c;

    public i(ArrayList arrayList) {
        this.f2743a = arrayList;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        be.h.e(obj, "proxy");
        be.h.e(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (be.h.a(name, "supports") && be.h.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (be.h.a(name, "unsupported") && be.h.a(Void.TYPE, returnType)) {
            this.f2744b = true;
            return null;
        }
        boolean zA = be.h.a(name, "protocols");
        ArrayList arrayList = this.f2743a;
        if (zA && objArr.length == 0) {
            return arrayList;
        }
        if ((be.h.a(name, "selectProtocol") || be.h.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof List) {
                List list = (List) obj2;
                int size = list.size();
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        Object obj3 = list.get(i);
                        be.h.c(obj3, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj3;
                        if (!arrayList.contains(str)) {
                            if (i == size) {
                                break;
                            }
                            i++;
                        } else {
                            this.f2745c = str;
                            return str;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f2745c = str2;
                return str2;
            }
        }
        if ((!be.h.a(name, "protocolSelected") && !be.h.a(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj4 = objArr[0];
        be.h.c(obj4, "null cannot be cast to non-null type kotlin.String");
        this.f2745c = (String) obj4;
        return null;
    }
}
