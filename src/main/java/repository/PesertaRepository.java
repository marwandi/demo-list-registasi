package repository;

import entity.PesertaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface PesertaRepository extends PagingAndSortingRepository<PesertaEntity, String> {

    @Query(value = "select p from  peserta p where p.kelas.id = ?1 ORDER BY id_kelas")
    public Page<PesertaEntity> findByKelasId(String id_kelas, Pageable pageable);
}
