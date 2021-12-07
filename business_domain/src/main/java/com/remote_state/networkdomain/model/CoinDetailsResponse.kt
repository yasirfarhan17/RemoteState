package com.remote_state.networkdomain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinDetailsResponse(
    val symbol: String,
    val parent: Parent,
    val proofType: String? = null,
    val description: String,
    val type: String,
    val contracts: List<ContractsItem?>? = null,
    val platform: String? = null,
    val lastDataAt: String,
    val whitepaper: Whitepaper? = null,
    val orgStructure: String? = null,
    val hardwareWallet: Boolean? = null,
    val developmentStatus: String? = null,
    val hashAlgorithm: String? = null,
    val rank: Int,
    val links: Links,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val contract: String? = null,
    val firstDataAt: String? = null,
    val team: List<TeamMember?>? = null,
    val linksExtended: List<LinksExtendedItem?>? = null,
    val message: String,
    val tags: List<TagsItem?>,
    val name: String,
    val startedAt: String? = null,
    val openSource: Boolean? = null
) : Parcelable

@Parcelize
data class TagsItem(
    val coinCounter: Int? = null,
    val icoCounter: Int? = null,
    val name: String? = null,
    val id: String? = null
) : Parcelable

@Parcelize
data class Whitepaper(
    val thumbnail: String? = null,
    val link: String? = null
) : Parcelable

@Parcelize
data class TeamMember(
    val name: String? = null,
    val id: String? = null,
    val position: String? = null
) : Parcelable

@Parcelize
data class LinksExtendedItem(
    val type: String? = null,
    val url: String? = null,
    val stats: Stats? = null
) : Parcelable

@Parcelize
data class Stats(
    val contributors: Int? = null,
    val stars: Int? = null,
    val subscribers: Int? = null
) : Parcelable

@Parcelize
data class Links(
    val youtube: List<String?>? = null,
    val website: List<String?>? = null,
    val facebook: List<String?>? = null,
    val explorer: List<String?>? = null,
    val reddit: List<String?>? = null,
    val medium: String? = null,
    val sourceCode: List<String?>? = null
) : Parcelable

@Parcelize
data class Parent(
    val symbol: String? = null,
    val name: String? = null,
    val id: String? = null
) : Parcelable

@Parcelize
data class ContractsItem(
    val contract: String? = null,
    val type: String? = null,
    val platform: String? = null
) : Parcelable
