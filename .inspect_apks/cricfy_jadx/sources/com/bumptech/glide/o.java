package com.bumptech.glide;

import com.google.android.gms.internal.measurement.i4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements com.bumptech.glide.manager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f2293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f2294b;

    public o(p pVar, i4 i4Var) {
        this.f2294b = pVar;
        this.f2293a = i4Var;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z10) {
        if (z10) {
            synchronized (this.f2294b) {
                i4 i4Var = this.f2293a;
                ArrayList arrayListE = s7.m.e((Set) i4Var.f2483x);
                int size = arrayListE.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListE.get(i);
                    i++;
                    o7.c cVar = (o7.c) obj;
                    if (!cVar.j() && !cVar.f()) {
                        cVar.clear();
                        if (i4Var.f2482w) {
                            ((HashSet) i4Var.f2484y).add(cVar);
                        } else {
                            cVar.h();
                        }
                    }
                }
            }
        }
    }
}
