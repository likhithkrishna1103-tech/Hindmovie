package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006-"}, d2 = {"Lcom/cncverse/LiveEventInfo;", "", "teamA", "", "teamB", "teamAFlag", "teamBFlag", "eventCat", "eventName", "eventLogo", "isHot", "eventType", "startTime", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTeamA", "()Ljava/lang/String;", "getTeamB", "getTeamAFlag", "getTeamBFlag", "getEventCat", "getEventName", "getEventLogo", "getEventType", "getStartTime", "getEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LiveEventInfo {

    @Nullable
    private final String endTime;

    @Nullable
    private final String eventCat;

    @Nullable
    private final String eventLogo;

    @Nullable
    private final String eventName;

    @Nullable
    private final String eventType;

    @Nullable
    private final String isHot;

    @Nullable
    private final String startTime;

    @Nullable
    private final String teamA;

    @Nullable
    private final String teamAFlag;

    @Nullable
    private final String teamB;

    @Nullable
    private final String teamBFlag;

    public static /* synthetic */ LiveEventInfo copy$default(LiveEventInfo liveEventInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveEventInfo.teamA;
        }
        if ((i & 2) != 0) {
            str2 = liveEventInfo.teamB;
        }
        if ((i & 4) != 0) {
            str3 = liveEventInfo.teamAFlag;
        }
        if ((i & 8) != 0) {
            str4 = liveEventInfo.teamBFlag;
        }
        if ((i & 16) != 0) {
            str5 = liveEventInfo.eventCat;
        }
        if ((i & 32) != 0) {
            str6 = liveEventInfo.eventName;
        }
        if ((i & 64) != 0) {
            str7 = liveEventInfo.eventLogo;
        }
        if ((i & 128) != 0) {
            str8 = liveEventInfo.isHot;
        }
        if ((i & 256) != 0) {
            str9 = liveEventInfo.eventType;
        }
        if ((i & 512) != 0) {
            str10 = liveEventInfo.startTime;
        }
        if ((i & 1024) != 0) {
            str11 = liveEventInfo.endTime;
        }
        String str12 = str10;
        String str13 = str11;
        String str14 = str8;
        String str15 = str9;
        String str16 = str6;
        String str17 = str7;
        String str18 = str5;
        String str19 = str3;
        return liveEventInfo.copy(str, str2, str19, str4, str18, str16, str17, str14, str15, str12, str13);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamA() {
        return this.teamA;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamB() {
        return this.teamB;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEventCat() {
        return this.eventCat;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIsHot() {
        return this.isHot;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    @NotNull
    public final LiveEventInfo copy(@Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventCat, @Nullable String eventName, @Nullable String eventLogo, @Nullable String isHot, @Nullable String eventType, @Nullable String startTime, @Nullable String endTime) {
        return new LiveEventInfo(teamA, teamB, teamAFlag, teamBFlag, eventCat, eventName, eventLogo, isHot, eventType, startTime, endTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveEventInfo)) {
            return false;
        }
        LiveEventInfo liveEventInfo = (LiveEventInfo) other;
        return Intrinsics.areEqual(this.teamA, liveEventInfo.teamA) && Intrinsics.areEqual(this.teamB, liveEventInfo.teamB) && Intrinsics.areEqual(this.teamAFlag, liveEventInfo.teamAFlag) && Intrinsics.areEqual(this.teamBFlag, liveEventInfo.teamBFlag) && Intrinsics.areEqual(this.eventCat, liveEventInfo.eventCat) && Intrinsics.areEqual(this.eventName, liveEventInfo.eventName) && Intrinsics.areEqual(this.eventLogo, liveEventInfo.eventLogo) && Intrinsics.areEqual(this.isHot, liveEventInfo.isHot) && Intrinsics.areEqual(this.eventType, liveEventInfo.eventType) && Intrinsics.areEqual(this.startTime, liveEventInfo.startTime) && Intrinsics.areEqual(this.endTime, liveEventInfo.endTime);
    }

    public int hashCode() {
        return ((((((((((((((((((((this.teamA == null ? 0 : this.teamA.hashCode()) * 31) + (this.teamB == null ? 0 : this.teamB.hashCode())) * 31) + (this.teamAFlag == null ? 0 : this.teamAFlag.hashCode())) * 31) + (this.teamBFlag == null ? 0 : this.teamBFlag.hashCode())) * 31) + (this.eventCat == null ? 0 : this.eventCat.hashCode())) * 31) + (this.eventName == null ? 0 : this.eventName.hashCode())) * 31) + (this.eventLogo == null ? 0 : this.eventLogo.hashCode())) * 31) + (this.isHot == null ? 0 : this.isHot.hashCode())) * 31) + (this.eventType == null ? 0 : this.eventType.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime != null ? this.endTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveEventInfo(teamA=").append(this.teamA).append(", teamB=").append(this.teamB).append(", teamAFlag=").append(this.teamAFlag).append(", teamBFlag=").append(this.teamBFlag).append(", eventCat=").append(this.eventCat).append(", eventName=").append(this.eventName).append(", eventLogo=").append(this.eventLogo).append(", isHot=").append(this.isHot).append(", eventType=").append(this.eventType).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(')');
        return sb.toString();
    }

    public LiveEventInfo(@Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventCat, @Nullable String eventName, @Nullable String eventLogo, @Nullable String isHot, @Nullable String eventType, @Nullable String startTime, @Nullable String endTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAFlag = teamAFlag;
        this.teamBFlag = teamBFlag;
        this.eventCat = eventCat;
        this.eventName = eventName;
        this.eventLogo = eventLogo;
        this.isHot = isHot;
        this.eventType = eventType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Nullable
    public final String getTeamA() {
        return this.teamA;
    }

    @Nullable
    public final String getTeamB() {
        return this.teamB;
    }

    @Nullable
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    public final String getEventCat() {
        return this.eventCat;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    public final String isHot() {
        return this.isHot;
    }

    @Nullable
    public final String getEventType() {
        return this.eventType;
    }

    @Nullable
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }
}
